package react.native

@JsModule("react-native")
private external object ReactNative {

	object Alert {

		fun alert(
			title: String?,
			message: String?,
			buttons: Array<react.native.Alert.Button>?
		)
	}
}

object Alert {

	class Button(
		val text: String,
		val onPress: (() -> Unit)? = null
	)

	fun alert(
		title: String? = null,
		message: String? = null,
		buttons: Array<Button>? = null
	) {
		ReactNative.Alert.alert(
			title = title,
			message = message,
			buttons = buttons
		)
	}
}