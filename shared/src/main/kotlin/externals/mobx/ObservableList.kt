package com.ivansadovyi.mobx

class ObservableList<E> : MutableList<E>, Observable {

	private val list = mutableListOf<E>()
	private val observers = mutableSetOf<Observer>()

	override val size: Int
		get() {
			triggerTracker()
			return this.list.size
		}

	override fun contains(element: E): Boolean {
		triggerTracker()
		return list.contains(element)
	}

	override fun containsAll(elements: Collection<E>): Boolean {
		triggerTracker()
		return list.containsAll(elements)
	}

	override fun get(index: Int): E {
		triggerTracker()
		return list[index]
	}

	override fun indexOf(element: E): Int {
		triggerTracker()
		return list.indexOf(element)
	}

	override fun isEmpty(): Boolean {
		triggerTracker()
		return list.isEmpty()
	}

	override fun iterator(): MutableIterator<E> {
		triggerTracker()
		return list.iterator()
	}

	override fun lastIndexOf(element: E): Int {
		triggerTracker()
		return list.lastIndexOf(element)
	}

	override fun add(element: E): Boolean {
		val result = list.add(element)
		notifyObservers()
		return result
	}

	override fun add(index: Int, element: E) {
		list.add(index, element)
		notifyObservers()
	}

	override fun addAll(index: Int, elements: Collection<E>): Boolean {
		val result = list.addAll(index, elements)
		notifyObservers()
		return result
	}

	override fun addAll(elements: Collection<E>): Boolean {
		val result = list.addAll(elements)
		notifyObservers()
		return result
	}

	override fun clear() {
		list.clear()
		notifyObservers()
	}

	override fun listIterator(): MutableListIterator<E> {
		triggerTracker()
		return list.listIterator()
	}

	override fun listIterator(index: Int): MutableListIterator<E> {
		triggerTracker()
		return list.listIterator(index)
	}

	override fun remove(element: E): Boolean {
		val result = list.remove(element)
		notifyObservers()
		return result
	}

	override fun removeAll(elements: Collection<E>): Boolean {
		val result = list.removeAll(elements)
		notifyObservers()
		return result
	}

	override fun removeAt(index: Int): E {
		val result = list.removeAt(index)
		notifyObservers()
		return result
	}

	override fun retainAll(elements: Collection<E>): Boolean {
		val result = list.retainAll(elements)
		notifyObservers()
		return result
	}

	override fun set(index: Int, element: E): E {
		val result = list.set(index, element)
		notifyObservers()
		return result
	}

	override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> {
		val result = list.subList(fromIndex, toIndex)
		triggerTracker()
		return result
	}

	fun triggerTracker() {
		val tracker = ObservableTrackerHolder.get()
		tracker?.track(this)
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
