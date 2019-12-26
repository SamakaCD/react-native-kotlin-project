package com.ivansadovyi.mobx

class TrackedObservable<T>(private var value: T) : Observable {

	private val observers = mutableSetOf<Observer>()

	fun get(): T {
		val tracker = ObservableTrackerHolder.get()
		tracker?.track(this)
		return value
	}

	fun set(value: T) {
		if (this.value !== value) {
			this.value = value
			notifyObservers()
		}
	}

	private fun notifyObservers() {
		val observers = mutableSetOf<Observer>()
		observers.addAll(this.observers)
		observers.forEach {
			it.onChange()
		}
	}

	override fun subscribe(observer: Observer): Disposable {
		observers.add(observer)
		return object : Disposable {
			override fun dispose() {
				observers.remove(observer)
			}
		}
	}
}
