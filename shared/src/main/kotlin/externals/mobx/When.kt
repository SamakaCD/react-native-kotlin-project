package com.ivansadovyi.mobx

class When(predicate: () -> Boolean, sideEffect: () -> Unit) : Disposable {

	private val disposable: Disposable

	init {
		disposable = Reaction(
			data = predicate,
			sideEffect = { data ->
				if (data) {
					dispose()
					sideEffect()
				}
			}
		)
	}

	override fun dispose() {
		disposable.dispose()
	}
}
