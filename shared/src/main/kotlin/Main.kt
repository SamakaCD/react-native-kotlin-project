package com.reactnativekotlinproject

import com.reactnativekotlinproject.externals.mobx.observableFunctionalComponent
import kotlinext.js.jsObject
import react.RProps
import react.native.AppRegistry
import react.native.Text
import react.useState

val App = observableFunctionalComponent<RProps> {
    val (viewModel) = useState { MainViewModel() }
    Text {
        attrs.onPress = {
            viewModel.increment()
        }
        attrs.style = jsObject {
            marginTop = 48
        }

        +"Hello world! "
        +"Counter value is: ${viewModel.value}"
    }
}

fun main() {
    AppRegistry.registerComponent("ReactNativeKotlinProject") {
        App
    }
}
