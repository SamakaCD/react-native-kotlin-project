package com.ivansadovyi.mobx

internal object ObservableTrackerHolder {

	private var current: ObservableTracker? = null

	fun get(): ObservableTracker? {
		return current
	}

	fun replaceTo(target: ObservableTracker, transaction: () -> Unit) {
		val prevTracker = current
		current = target
		transaction()
		current = prevTracker
	}
}
