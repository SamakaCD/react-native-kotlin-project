package com.ivansadovyi.mobx

typealias ActionListener = (Any?) -> Unit
typealias ActionNestingListener = (Int) -> Unit

class Action(payload: Any? = null, body: () -> Unit) {

	init {
		currentNesting++
		notifyNestingListeners()
		body()
		currentNesting--
		notifyNestingListeners()
		notifyActionListeners(payload)
	}

	companion object {

		private val actionListeners = mutableSetOf<ActionListener>()
		private val nestingListeners = mutableSetOf<ActionNestingListener>()
		var currentNesting = 0
			private set

		fun listen(listener: ActionListener): Disposable {
			actionListeners.add(listener)
			return object : Disposable {
				override fun dispose() {
					actionListeners.remove(listener)
				}
			}
		}

		fun listenNestingChanges(listener: ActionNestingListener): Disposable {
			nestingListeners += listener
			return object : Disposable {
				override fun dispose() {
					nestingListeners.remove(listener)
				}
			}
		}

		private fun notifyActionListeners(payload: Any?) {
			actionListeners.forEach {
				it(payload)
			}
		}

		private fun notifyNestingListeners() {
			nestingListeners.forEach {
				it(currentNesting)
			}
		}
	}
}
