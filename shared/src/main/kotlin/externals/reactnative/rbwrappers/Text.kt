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

object FontStyle {
	const val NORMAL = "normal"
	const val ITALIC = "italic"
}

object FontWeight {
	const val NORMAL = "normal"
	const val BOLD = "bold"
}

object TextAlign {
	const val AUTO = "auto"
	const val LEFT = "left"
	const val RIGHT = "right"
	const val CENTER = "center"
	const val JUSTIFY = "justify"
}

object TextDecorationLine {
	const val NONE = "none"
	const val UNDERLINE = "underline"
	const val LINE_THROUGH = "line-through"
	const val UNDERLINE_LINE_THROUGH = "underline line-through"
}

object TextAlignVertical {
	const val AUTO = "auto"
	const val TOP = "top"
	const val BOTTOM = "bottom"
	const val CENTER = "center"
}

object TextTrasform {
	const val NONE = "none"
	const val UPPERCASE = "uppercase"
	const val LOWERCASE = "lowercase"
	const val CAPITALIZE = "capitalize"
}

object WritingDirection {
	const val AUTO = "auto"
	const val LTR = "ltr"
	const val RTL = "rtl"
}

fun textStyle(body: TextStyle.() -> Unit) = jsObject(body)