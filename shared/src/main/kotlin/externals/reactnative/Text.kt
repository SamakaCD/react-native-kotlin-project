package react.native

import kotlinext.js.jsObject
import react.*

@JsModule("react-native")
private external object ReactNative_Text {

	val Text: RClass<TextProps>
}

interface TextStyle : ViewStyle {
	var color: String?
	var fontSize: Float?
	var fontStyle: String?
	var fontWeight: String?
	var lineHeight: Float?
	var textAlign: String?
	var textDecorationLine: String?
	var fontFamily: String?
	var includeFontPadding: Boolean?
	var textAlignVertical: String?
	var textTransform: String?
	var writingDirection: String?
}

interface TextProps : RProps {
	var style: TextStyle?
	var onPress: (() -> Unit)?
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

fun RBuilder.text(
	style: TextStyle? = undefined,
	onPress: (() -> Unit)? = undefined,
	children: RHandler<TextProps>
): ReactElement {
	return child(ReactNative_Text.Text, jsObject {
		this.style = style
		this.onPress = onPress
	}, children)
}

fun textStyle(body: TextStyle.() -> Unit) = jsObject(body)
