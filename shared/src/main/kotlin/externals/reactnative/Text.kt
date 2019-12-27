@file:JsModule("react-native")

package react.native

import react.RClass
import react.RProps

external interface TextStyle : ViewStyle {
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

external interface TextProps : RProps {
	var style: TextStyle?
	var onPress: (() -> Unit)?
}

external val Text: RClass<TextProps>