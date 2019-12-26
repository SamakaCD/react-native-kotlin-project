package com.reactnativekotlinproject

import kotlinext.js.jsObject
import react.RProps
import react.functionalComponent
import react.native.AppRegistry
import react.native.Text

val App = functionalComponent<RProps> {
    Text {
        attrs.style = jsObject {
            marginTop = 48
        }

        +"Hello world!"
    }
}

fun main() {
    AppRegistry.registerComponent("ReactNativeKotlinProject") {
        App
    }
}
