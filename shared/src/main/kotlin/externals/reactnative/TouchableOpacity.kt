@file:JsModule("react-native")

package react.native

import react.RClass
import react.RProps

external interface TouchableOpacityProps : RProps {
	var activeOpacity: Float?
	var style: ViewStyle?
	var onPress: (() -> Unit)?
}

external val TouchableOpacity: RClass<TextProps>