package com.ivansadovyi.mobx

class Reaction<R>(data: () -> R, sideEffect: (R) -> Unit) : Disposable {

	private val disposable: Disposable
	private var wasFirstAutorunOccurred = false

	init {
		disposable = Autorun {
			val data = data()
			if (wasFirstAutorunOccurred) {
				sideEffect(data)
			}
			wasFirstAutorunOccurred = true
		}
	}

	override fun dispose() {
		disposable.dispose()
	}
}
