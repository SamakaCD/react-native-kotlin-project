package com.reactnativekotlinproject

import com.reactnativekotlinproject.externals.mobx.observableFunctionalComponent
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.*
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
		alignItems = AlignItems.CENTER
		justifyContent = JustifyContent.CENTER
		width = 100f
		height = 100f
		backgroundColor = "#3F51B5"
	}

	val text = textStyle {
		color = "white"
	}
}

val App = observableFunctionalComponent<RProps> {
	view(style = Styles.container) {
		view(style = Styles.child) {
			text(style = Styles.text) {
				+"Hello world!"
			}
		}
	}
}

fun main() {
	AppRegistry.registerComponent("ReactNativeKotlinProject") {
		App
	}
}
