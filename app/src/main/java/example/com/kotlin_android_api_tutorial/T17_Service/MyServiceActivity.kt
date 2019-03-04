package example.com.kotlin_android_api_tutorial.T17_Service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.support.v7.app.AppCompatActivity
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_my_service.*

class MyServiceActivity : AppCompatActivity() {

    var myBoundService: MyBoundService? = null
    var isBound = false

//    private val myConnection = object : ServiceConnection {
//        override fun onServiceConnected(className: ComponentName,
//                                        service: IBinder) {
//            val binder = service as MyBoundService.MyLocalBinder
//            myBoundService = binder.getService()
//            isBound = true
//        }
//
//        override fun onServiceDisconnected(name: ComponentName) {
//            isBound = false
//        }
//    }


    var myService: Messenger? = null
    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected( className: ComponentName, service: IBinder) {
            myService = Messenger(service)
            isBound = true
        }

        override fun onServiceDisconnected(
            className: ComponentName) {
            myService = null
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)

//        val intent = Intent(this, MyBoundService::class.java)
//        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

        val intent = Intent(getApplicationContext(), MyRemoteService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

        btnStartService.setOnClickListener {
            val myIntent = Intent(this, MyService::class.java)
            startService(myIntent)
        }
        btnBoundService.setOnClickListener {
            showTime()
        }
        btnRemoteSend.setOnClickListener {
            sendMessage()
        }

    }

    private fun showTime(){
        btnBoundService.text = myBoundService?.getCurrentTime()
    }


    private fun sendMessage(){
        if (!isBound) return

        val msg = Message.obtain()

        val bundle = Bundle()
        bundle.putString("MyString", "Message Received")

        msg.data = bundle

        try {
            myService?.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(myConnection)
    }
}
