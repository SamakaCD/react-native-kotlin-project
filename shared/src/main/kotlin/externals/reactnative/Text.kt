@file:JsModule("react-native")

package react.native

import react.RClass
import react.RProps

external interface TextStyle {
    var marginTop: Int
}

external interface TextProps : RProps {
    var style: TextStyle
    var onPress: () -> Unit
}

external val Text: RClass<TextProps>