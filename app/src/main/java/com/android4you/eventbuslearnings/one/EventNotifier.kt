package com.android4you.eventbuslearnings.one

class EventNotifier {

    private val listeners: MutableSet<EventListener> = HashSet()

    fun addListener(eventListener: EventListener) {
        listeners.add(eventListener)
    }

    fun removeListener(eventListener: EventListener) {
        listeners.remove(eventListener)
    }

    fun notifyEvent(event: Event) {
        listeners.forEach {
            it.onEventTriggered(event)
        }
    }
}