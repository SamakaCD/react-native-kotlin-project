@file:JsModule("react-native")

package react.native

import react.RClass
import react.RProps

external interface ViewStyle {
    var alignContent: String?
    var alignItems: String?
    var alignSelf: String?
    var aspectRatio: Float?
    var backgroundColor: String?
    var flex: Float?
    var height: Float?
    var justifyContent: String?
    var marginTop: Int?
    var width: Float?
}

external interface ViewProps : RProps {
    var style: ViewStyle?
}

external val View: RClass<ViewProps>
