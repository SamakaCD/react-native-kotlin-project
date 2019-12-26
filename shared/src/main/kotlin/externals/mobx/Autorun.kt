package com.ivansadovyi.mobx

class Autorun(private val body: () -> Unit) : Disposable, ObservableTracker, Observer {

	private val childObservableDisposables = mutableSetOf<Disposable>()
	private val actionNestingListenerDisposable: Disposable
	private var hasPendingBodyInvocation = false

	private val actionNestingListener: ActionNestingListener = { nesting ->
		if (nesting == 0 && hasPendingBodyInvocation) {
			runBody()
		}
	}

	init {
		actionNestingListenerDisposable = Action.listenNestingChanges(actionNestingListener)
		runBody()
	}

	override fun dispose() {
		disposeChildObservables()
		actionNestingListenerDisposable.dispose()
	}

	override fun track(observable: Observable) {
		val disposable = observable.subscribe(this)
		childObservableDisposables.add(disposable)
	}

	override fun onChange() {
		if (Action.currentNesting == 0) {
			runBody()
		} else {
			hasPendingBodyInvocation = true
		}
	}

	private fun disposeChildObservables() {
		for (disposable in childObservableDisposables) {
			disposable.dispose()
		}
	}

	private fun runBody() {
		ObservableTrackerHolder.replaceTo(this) {
			disposeChildObservables()
			body()
		}
	}
}
