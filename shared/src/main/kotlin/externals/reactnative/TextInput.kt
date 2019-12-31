package com.reactnativekotlinproject.externals.reactnative

import kotlinext.js.jsObject
import react.*
import react.native.TextStyle

@JsModule("react-native")
private external object ReactNative_TextInput {

	val TextInput: RClass<TextInputProps>
}

interface TextInputProps : RProps {
	var autoFocus: Boolean?
	var multiline: Boolean?
	var onChangeText: (String) -> Unit
	var style: TextStyle?
	var value: String
}

fun RBuilder.textInput(
	autoFocus: Boolean? = undefined,
	multiline: Boolean? = undefined,
	style: TextStyle? = undefined,
	onChangeText: (String) -> Unit,
	value: String,
	children: RHandler<TextInputProps> = { }
): ReactElement {
	return child(ReactNative_TextInput.TextInput, jsObject {
		this.autoFocus = autoFocus
		this.multiline = multiline
		this.onChangeText = onChangeText
		this.style = style
		this.value = value
	}, children)
}