package com.ivansadovyi.mobx

interface Observable {

	fun subscribe(observer: Observer): Disposable
}