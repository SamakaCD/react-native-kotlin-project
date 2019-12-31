package react.native

import kotlinext.js.jsObject
import react.*

@JsModule("react-native")
private external object ReactNative_Image {

	val Image: RClass<ImageProps>
}

interface ImageStyle : ViewStyle {
	var tintColor: String?
}

interface ImageProps : RProps {
	var resizeMode: String?
	var source: dynamic
	var style: ImageStyle?
}

object ImageResizeMode {
	const val COVER = "cover"
	const val CONTAIN = "contain"
	const val STRETCH = "stretch"
	const val REPEAT = "repeat"
	const val CENTER = "center"
}

fun RBuilder.image(
	style: ImageStyle? = undefined,
	sourceUri: String? = null,
	source: dynamic = undefined,
	children: RHandler<ImageProps> = { }
): ReactElement {
	return child(ReactNative_Image.Image, jsObject {
		this.source = if (sourceUri != null) {
			kotlin.js.json("uri" to sourceUri)
		} else {
			source
		}

		this.style = style
	}, children)
}

fun imageStyle(body: ImageStyle.() -> Unit) = jsObject(body)
