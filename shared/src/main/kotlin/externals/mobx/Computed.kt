package com.ivansadovyi.mobx

class Computed<R>(private val body: () -> R) : ObservableTracker, Observer {

	private var memoizedResult: R? = null
	private var needRecalculation = true
	private val children = mutableSetOf<Observable>()
	private var isStoringTrackedObservable = false

	fun get(): R {
		if (needRecalculation) {
			ObservableTrackerHolder.replaceTo(this) {
				memoizedResult = body()
			}
		}

		val tracker = ObservableTrackerHolder.get()
		if (tracker != null) {
			for (observable in children) {
				tracker.track(observable)
			}
		}

		return memoizedResult!!
	}

	override fun track(observable: Observable) {
		if (!isStoringTrackedObservable) {
			isStoringTrackedObservable = true
			observable.subscribe(this)
			children.add(observable)
			isStoringTrackedObservable = false
		}
	}

	override fun onChange() {
		needRecalculation = true
	}
}
