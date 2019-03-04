package example.com.kotlin_android_api_tutorial.T17_Service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class MyBoundService : Service() {

    inner class MyLocalBinder : Binder() {
        fun getService() : MyBoundService {
            return this@MyBoundService
        }
    }

    private val myBinder = MyLocalBinder()

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }


    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy")
        return dateformat.format(Date())
    }
}
