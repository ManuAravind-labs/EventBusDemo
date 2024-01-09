package com.android4you.eventbuslearnings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android4you.eventbuslearnings.databinding.ActivityMainBinding
import com.android4you.eventbuslearnings.one.Event
import com.android4you.eventbuslearnings.one.EventNotifier
import com.android4you.eventbuslearnings.one.EventListener

class MainActivity : AppCompatActivity(), EventListener {

    private lateinit var eventBroadcaster: EventNotifier
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventBroadcaster = EventNotifier()
        binding.buttonOne.setOnClickListener {
            val event = Event("Button-Clicked") // Sending the Event
            eventBroadcaster.notifyEvent(event)
        }
    }

    override fun onEventTriggered(event: Event) {
        Toast.makeText(this, "Event Received", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        eventBroadcaster.addListener(this)
    }

    override fun onStop() {
        super.onStop()
        eventBroadcaster.removeListener(this)
    }
}
