package com.app

class Product {

    String name

    static constraints = {
        name(blank: false, minSize: 2, maxSize: 255)
    }
}
