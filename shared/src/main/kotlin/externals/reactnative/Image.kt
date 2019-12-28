@file:JsModule("react-native")

package react.native

import react.RClass
import react.RProps

external interface ImageStyle : ViewStyle {
	var tintColor: String?
}

external interface ImageProps : RProps {
	var resizeMode: String?
	var source: dynamic
	var style: ImageStyle?
}

external val Image: RClass<ImageProps>