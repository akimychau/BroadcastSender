package ru.akimychev.broadcastsender

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// Имя ACTION для Broadcast, по нему Receiver и будет определяться
private const val ACTION_SEND_MSG = "ru.akimychev.broadcastsender.message"

// Имя передаваемого параметра
private const val NAME_MSG = "MSG"

// Эта константа спрятана в Intent классе,
// Но, именно посредством её можно поднять приложение
const val FLAG_RECEIVER_INCLUDE_BACKGROUND: Int = 0x01000000

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButtonSend()
    }

    private fun initButtonSend() {
        findViewById<Button>(R.id.buttonSend).setOnClickListener {
            Intent().apply {
                action = ACTION_SEND_MSG
                putExtra(NAME_MSG, findViewById<EditText>(R.id.textMessage).text.toString())
                addFlags(FLAG_RECEIVER_INCLUDE_BACKGROUND)
                sendBroadcast(this)
            }
        }
    }
}