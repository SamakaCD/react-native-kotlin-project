package com.ivansadovyi.mobx

fun autorun(body: () -> Unit): Disposable {
	return Autorun(body)
}

fun <R> reaction(data: () -> R, sideEffect: (R) -> Unit): Disposable {
	return Reaction(data, sideEffect)
}

fun whenThen(predicate: () -> Boolean, sideEffect: () -> Unit): Disposable {
	return When(predicate, sideEffect)
}

fun <T> observable(valueSupplier: () -> T): TrackedObservableVariable<T> {
	return TrackedObservableVariable(valueSupplier())
}

fun <T> observable(value: T): TrackedObservableVariable<T> {
	return TrackedObservableVariable(value)
}

fun <T> computed(body: () -> T): ComputedVariable<T> {
	return ComputedVariable(body)
}

fun action(body: () -> Unit) {
	Action(body = body)
}

fun action(payload: Any?, body: () -> Unit) {
	Action(payload, body)
}