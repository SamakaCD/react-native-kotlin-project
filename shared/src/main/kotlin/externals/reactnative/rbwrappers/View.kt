package com.reactnativekotlinproject.externals.reactnative.rbwrappers

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.native.View
import react.native.ViewProps
import react.native.ViewStyle

fun RBuilder.view(
        style: ViewStyle? = undefined,
        children: RHandler<ViewProps> = { }
): ReactElement {
    return child(View, jsObject {
        this.style = style
    }, children)
}

enum class AlignContent(val value: String) {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    STRETCH("stretch"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around")
}

enum class AlignItems(val value: String) {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    STRETCH("stretch"),
    BASELINE("baseline")
}

enum class AlignSelf(val value: String) {
    AUTO("auto"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    STRETCH("stretch"),
    BASELINE("baseline")
}

enum class JustifyContent(val value: String) {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    SPACE_EVENLY("space-evenly")
}

interface TypeSafeViewStyle {
    var alignContent: AlignContent?
    var alignItems: AlignItems?
    var alignSelf: AlignSelf?
    var aspectRatio: Float?
    var backgroundColor: String?
    var flex: Float?
    var height: Float?
    var justifyContent: JustifyContent?
    var marginTop: Int?
    var width: Float?
}

fun viewStyle(body: TypeSafeViewStyle.() -> Unit): ViewStyle {
    val typeSafeStyle = jsObject(body)
    return jsObject {
        alignContent = typeSafeStyle.alignContent?.value
        alignItems = typeSafeStyle.alignItems?.value
        alignSelf = typeSafeStyle.alignSelf?.value
        aspectRatio = typeSafeStyle.aspectRatio
        backgroundColor = typeSafeStyle.backgroundColor
        flex = typeSafeStyle.flex
        height = typeSafeStyle.height
        justifyContent = typeSafeStyle.justifyContent?.value
        marginTop = typeSafeStyle.marginTop
        width = typeSafeStyle.width
    }
}