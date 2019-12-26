@file:JsModule("react-native")

package react.native

external object AppRegistry {

    fun registerComponent(appKey: String, componentProvider: () -> dynamic)
}