package com.reactnativekotlinproject.externals.reactnative.rbwrappers

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.native.Text
import react.native.TextProps
import react.native.TextStyle

fun RBuilder.text(
	style: TextStyle? = undefined,
	onPress: (() -> Unit)? = undefined,
	children: RHandler<TextProps>
): ReactElement {
	return child(Text, jsObject {
		this.style = style
		this.onPress = onPress
	}, children)
}

fun textStyle(body: TextStyle.() -> Unit) = jsObject(body)