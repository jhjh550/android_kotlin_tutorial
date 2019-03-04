package example.com.kotlin_android_api_tutorial.T16_BR

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_br.*


// todo : https://developer.android.com/guide/components/broadcast-exceptions

class BRActivity : AppCompatActivity() {

    var receiver : MyReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_br)
        btnSendBR.setOnClickListener {
            val intent = Intent("abcdef")
            sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        intentFilter.addAction("abcdef")

        receiver = MyReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()

        unregisterReceiver(receiver)
    }

}
