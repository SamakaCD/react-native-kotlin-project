package com.reactnativekotlinproject

import com.reactnativekotlinproject.externals.mobx.observableFunctionalComponent
import com.reactnativekotlinproject.externals.reactnative.rbwrappers.*
import react.RProps
import react.native.AppRegistry
import react.useState

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
		padding = 16f
		borderRadius = 16f
		backgroundColor = "#3F51B5"
	}

	val text = textStyle {
		color = "white"
	}
}

val App = observableFunctionalComponent<RProps> {
	val (viewModel) = useState { MainViewModel() }
	view(style = Styles.container) {
		touchableOpacity(
			style = Styles.child,
			onPress = viewModel::increment
		) {
			text(style = Styles.text) {
				+"Hello world! ${viewModel.value}"
			}
		}
	}
}

fun main() {
	AppRegistry.registerComponent("ReactNativeKotlinProject") {
		App
	}
}
