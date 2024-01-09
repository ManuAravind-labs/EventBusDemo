package com.android4you.eventbuslearnings.one

interface EventListener {
    fun onEventTriggered(event: Event)
}