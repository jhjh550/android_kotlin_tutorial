package example.com.kotlin_android_api_tutorial.T10_Thread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_thread.*
import java.lang.Thread.sleep

class ThreadActivity : AppCompatActivity() {
    private val MY_COUNT = 100

    var handler = object : Handler(){
        override fun handleMessage(msg: Message?) {
            if(msg?.what == MY_COUNT){
                btnThread.text = "count : ${msg.arg1}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        btnThread.setOnClickListener {
//            val th = Thread(){
//                kotlin.run {
//                  threadCount()
//                }
//            }

//            val th = Thread(Runnable {
//                threadCount()
//            })

            val th = Thread {
                threadCount()
            }
            th.start()
        }
    }

    private fun threadCount(){
        for (i in 0..100) {
            Log.d("thread", "count $i")
            val msg = handler.obtainMessage()
            msg.what = MY_COUNT
            msg.arg1 = i
            handler.sendMessage(msg)
            sleep(100)

        }
    }
}
