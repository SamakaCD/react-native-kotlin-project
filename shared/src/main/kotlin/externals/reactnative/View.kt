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

external interface ViewProps : RProps {
	var style: ViewStyle?
}

external val View: RClass<ViewProps>
