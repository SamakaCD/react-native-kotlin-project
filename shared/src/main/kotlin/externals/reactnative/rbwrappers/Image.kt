package com.reactnativekotlinproject.externals.reactnative.rbwrappers

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.native.Image
import react.native.ImageProps
import react.native.ImageStyle
import kotlin.js.json

fun RBuilder.image(
	style: ImageStyle? = undefined,
	sourceUri: String? = null,
	source: dynamic = undefined,
	children: RHandler<ImageProps> = { }
): ReactElement {
	return child(Image, jsObject {
		this.source = if (sourceUri != null) {
			json("uri" to sourceUri)
		} else {
			source
		}

		this.style = style
	}, children)
}

object ImageResizeMode {
	const val COVER = "cover"
	const val CONTAIN = "contain"
	const val STRETCH = "stretch"
	const val REPEAT = "repeat"
	const val CENTER = "center"
}

fun imageStyle(body: ImageStyle.() -> Unit) = jsObject(body)