package com.reactnativekotlinproject

import com.reactnativekotlinproject.externals.mobx.observableFunctionalComponent
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.AlignItems
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.JustifyContent
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.view
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.viewStyle
import react.RProps
import react.native.AppRegistry

object Styles {
	val container = viewStyle {
		alignItems = AlignItems.CENTER
		justifyContent = JustifyContent.CENTER
		backgroundColor = "#F5F5F5"
		flex = 1f
	}

	val child = viewStyle {
		width = 100f
		height = 100f
		backgroundColor = "#3F51B5"
	}
}

val App = observableFunctionalComponent<RProps> {
	view(
		style = Styles.container,
		children = {
			view(style = Styles.child)
		}
	)
}

fun main() {
	AppRegistry.registerComponent("ReactNativeKotlinProject") {
		App
	}
}
