package com.reactnativekotlinproject

import com.ivansadovyi.mobx.observable

class MainViewModel {

    var value by observable { 0 }

    init {
        println("View model init")
    }

    fun increment() {
        value++
        println("Increment")
    }
}