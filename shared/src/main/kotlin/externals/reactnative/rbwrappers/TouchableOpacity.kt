package com.reactnativekotlinproject.externals.reactnative.rbwrappers

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.native.TouchableOpacity
import react.native.TouchableOpacityProps
import react.native.ViewStyle

fun RBuilder.touchableOpacity(
	activeOpacity: Float? = undefined,
	style: ViewStyle? = undefined,
	onPress: (() -> Unit)? = undefined,
	children: RHandler<TouchableOpacityProps>
): ReactElement {
	return child(TouchableOpacity, jsObject {
		this.activeOpacity = activeOpacity
		this.style = style
		this.onPress = onPress
	}, children)
}
