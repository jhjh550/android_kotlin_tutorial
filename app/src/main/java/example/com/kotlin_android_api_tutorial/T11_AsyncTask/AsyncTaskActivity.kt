package example.com.kotlin_android_api_tutorial.T11_AsyncTask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_async_task.*

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        btnAsyncTask.setOnClickListener {
            val myTask = MyTask()
            myTask.execute(30)
        }
    }

    private inner class MyTask : AsyncTask<Int, Float, String?>(){
        override fun doInBackground(vararg params: Int?): String? {
            for(i in params[0]!!..100){
                Thread.sleep(100)
                publishProgress(i.toFloat())
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Float?) {
            super.onProgressUpdate(*values)
            btnAsyncTask.text = values[0].toString()

        }


    }
}
