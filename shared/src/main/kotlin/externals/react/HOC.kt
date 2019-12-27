package react

import kotlinext.js.JsFunction

external interface HOC<out P : RProps, in R : RProps> : JsFunction<Nothing?, RClass<R>>

operator fun <P : RProps, R : RProps> HOC<P, R>.invoke(component: RClass<P>) =
	call(null, component)

operator fun <P : RProps, R : RProps> HOC<P, R>.invoke(component: RBuilder.(P) -> Unit) =
	call(null, { props: P ->
		buildElements {
			component(props)
		}
	})

operator fun <P : RProps, R : RProps> HOC<P, R>.invoke(config: Any, component: RBuilder.(P) -> Unit) =
	call(null, { props: P ->
		buildElements {
			component(props)
		}
	}, config)

fun <P : RProps> allOf(vararg hocs: HOC<P, P>): (component: RClass<P>) -> RClass<P> =
	{ hocs.fold(it) { acc, hoc -> hoc(acc) } }
