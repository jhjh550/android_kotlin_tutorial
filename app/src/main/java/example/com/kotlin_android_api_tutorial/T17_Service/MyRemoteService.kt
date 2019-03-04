package example.com.kotlin_android_api_tutorial.T17_Service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.widget.Toast
import java.util.*

class MyRemoteService : Service() {

    private val myMessenger = Messenger(IncomingHandler())

    inner class IncomingHandler : Handler() {
        override fun handleMessage(msg: Message) {

            val data = msg.data
            val dataString = data.getString("MyString")
            Toast.makeText(applicationContext, dataString, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return myMessenger.binder
    }

}
