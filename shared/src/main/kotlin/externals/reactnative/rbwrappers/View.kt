package com.reactnativekotlinproject.externals.reactnative.rbwrappers

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.native.View
import react.native.ViewProps
import react.native.ViewStyle

fun RBuilder.view(
	style: ViewStyle? = undefined,
	children: RHandler<ViewProps> = { }
): ReactElement {
	return child(View, jsObject {
		this.style = style
	}, children)
}

object AlignContent {
	const val FLEX_START = "flex-start"
	const val FLEX_END = "flex-end"
	const val CENTER = "center"
	const val STRETCH = "stretch"
	const val SPACE_BETWEEN = "space-between"
	const val SPACE_AROUND = "space-around"
}

object AlignItems {
	const val FLEX_START = "flex-start"
	const val FLEX_END = "flex-end"
	const val CENTER = "center"
	const val STRETCH = "stretch"
	const val BASELINE = "baseline"
}

object AlignSelf {
	const val AUTO = "auto"
	const val FLEX_START = "flex-start"
	const val FLEX_END = "flex-end"
	const val CENTER = "center"
	const val STRETCH = "stretch"
	const val BASELINE = "baseline"
}

object JustifyContent {
	const val FLEX_START = "flex-start"
	const val FLEX_END = "flex-end"
	const val CENTER = "center"
	const val SPACE_BETWEEN = "space-between"
	const val SPACE_AROUND = "space-around"
	const val SPACE_EVENLY = "space-evenly"
}

object Direction {
	const val INHERIT = "inherit"
	const val LTR = "ltr"
	const val RTL = "rtl"
}

object FlexDirection {
	const val ROW = "row"
	const val ROW_REVERSE = "row-reverse"
	const val COLUMN = "column"
	const val COLUMN_REVERSE = "column-reverse"
}

object FlexWrap {
	const val WRAP = "wrap"
	const val NO_WRAP = "nowrap"
}

object Overflow {
	const val VISIBLE = "visible"
	const val HIDDEN = "hidden"
	const val SCROLL = "scroll"
}

object Position {
	const val ABSOLUTE = "absolute"
	const val RELATIVE = "relative"
}

fun viewStyle(body: ViewStyle.() -> Unit) = jsObject(body)