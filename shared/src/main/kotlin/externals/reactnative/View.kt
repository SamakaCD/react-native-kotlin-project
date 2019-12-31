package react.native

import kotlinext.js.jsObject
import react.*

@JsModule("react-native")
private external object ReactNative_View {

	val View: RClass<ViewProps>
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

interface ViewStyle {
	var alignContent: String?
	var alignItems: String?
	var alignSelf: String?
	var aspectRatio: Float?
	var backgroundColor: String?
	var borderColor: String?
	var borderRadius: dynamic
	var borderBottomWidth: Float?
	var borderEndWidth: Float?
	var borderLeftWidth: Float?
	var borderRightWidth: Float?
	var borderStartWidth: Float?
	var borderTopWidth: Float?
	var borderWidth: Float?
	var bottom: Float?
	var direction: String?
	var end: dynamic
	var flex: Float?
	var flexDirection: String?
	var flexGrow: Float?
	var flexShrink: Float?
	var flexWrap: String?
	var height: dynamic
	var justifyContent: String?
	var left: dynamic
	var margin: Float?
	var marginBottom: Float?
	var marginEnd: Float?
	var marginHorizontal: Float?
	var marginLeft: Float?
	var marginRight: Float?
	var marginStart: Float?
	var marginVertica: Float?
	var marginTop: Float?
	var maxHeight: dynamic
	var maxWidth: dynamic
	var minHeight: dynamic
	var minWidth: dynamic
	var overflow: String?
	var padding: Float?
	var paddingBottom: Float?
	var paddingEnd: Float?
	var paddingHorizontal: Float?
	var paddingLeft: Float?
	var paddingRight: Float?
	var paddingStart: Float?
	var paddingTop: Float?
	var paddingVertical: Float?
	var position: String?
	var right: dynamic
	var start: dynamic
	var top: dynamic
	var width: dynamic
	var zIndex: Int?
}

interface ViewProps : RProps {
	var style: ViewStyle?
}

fun RBuilder.view(
	style: ViewStyle? = undefined,
	children: RHandler<ViewProps> = { }
): ReactElement {
	return child(ReactNative_View.View, jsObject {
		this.style = style
	}, children)
}

fun viewStyle(body: ViewStyle.() -> Unit) = jsObject(body)
