package react.native

import kotlinext.js.jsObject
import react.*

@JsModule("react-native")
private external object ReactNative_TouchableOpacity {

	val TouchableOpacity: RClass<TouchableOpacityProps>
}

interface TouchableOpacityProps : RProps {
	var activeOpacity: Float?
	var style: ViewStyle?
	var onPress: (() -> Unit)?
}

fun RBuilder.touchableOpacity(
	activeOpacity: Float? = undefined,
	style: ViewStyle? = undefined,
	onPress: (() -> Unit)? = undefined,
	children: RHandler<TouchableOpacityProps> = { }
): ReactElement {
	return child(ReactNative_TouchableOpacity.TouchableOpacity, jsObject {
		this.activeOpacity = activeOpacity
		this.style = style
		this.onPress = onPress
	}, children)
}
