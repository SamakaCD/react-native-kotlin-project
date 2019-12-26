package com.reactnativekotlinproject

import com.reactnativekotlinproject.externals.mobx.observableFunctionalComponent
import com.reactnativekotlinproject.rbwrappers.reactnative.text
import kotlinext.js.jsObject
import react.RProps
import react.native.AppRegistry
import react.useState

val App = observableFunctionalComponent<RProps> {
    val (viewModel) = useState { MainViewModel() }
    text(
            style = jsObject {
                marginTop = 48
            },
            onPress = viewModel::increment,
            children = {
                +"Hello world! "
                +"Counter value is: ${viewModel.value}"
            }
    )
}

fun main() {
    AppRegistry.registerComponent("ReactNativeKotlinProject") {
        App
    }
}
