package app

import com.app.Product
import com.vaadin.data.fieldgroup.FieldGroup
import com.vaadin.data.util.BeanItem
import com.vaadin.data.validator.StringLengthValidator
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.FormLayout
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

class MyUI extends UI {

    @Override
    protected void init(VaadinRequest r) {

        VerticalLayout layout = new VerticalLayout()

        Product product = new Product()
        product.name = "iPhone 7"
        product.save()

        FormLayout form = new FormLayout()
        FieldGroup binder = new FieldGroup(new BeanItem(product))

        TextField txnName = binder.buildAndBind("Name", "name")
        txnName.setNullRepresentation("")

        def constraints = Product.constraints
        def name = constraints.name

        int minSize = name.minSize
        int maxSize = name.maxSize
        boolean blank = name.blank

        StringLengthValidator validator = new StringLengthValidator("Validation failed", minSize, maxSize, blank)
        txnName.addValidator(validator)

        form.addComponent(txnName)

        layout.addComponent(form)

        setContent(layout)
    }
}
