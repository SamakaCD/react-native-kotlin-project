package com.ivansadovyi.mobx

class ObservableMap<K, V> : MutableMap<K, V>, Observable {

	private val map = mutableMapOf<K, V>()
	private val observers = mutableSetOf<Observer>()

	override val size: Int
		get() {
			triggerTracker()
			return map.size
		}

	override fun containsKey(key: K): Boolean {
		triggerTracker()
		return map.containsKey(key)
	}

	override fun containsValue(value: V): Boolean {
		triggerTracker()
		return map.containsValue(value)
	}

	override fun get(key: K): V? {
		triggerTracker()
		return map[key]
	}

	override fun isEmpty(): Boolean {
		triggerTracker()
		return map.isEmpty()
	}

	override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
		get() {
			triggerTracker()
			return map.entries
		}

	override val keys: MutableSet<K>
		get() {
			triggerTracker()
			return map.keys
		}

	override val values: MutableCollection<V>
		get() {
			triggerTracker()
			return map.values
		}

	override fun clear() {
		map.clear()
		notifyObservers()
	}

	override fun put(key: K, value: V): V? {
		val result = map.put(key, value)
		notifyObservers()
		return result
	}

	override fun putAll(from: Map<out K, V>) {
		map.putAll(from)
		notifyObservers()
	}

	override fun remove(key: K): V? {
		val result = map.remove(key)
		notifyObservers()
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
