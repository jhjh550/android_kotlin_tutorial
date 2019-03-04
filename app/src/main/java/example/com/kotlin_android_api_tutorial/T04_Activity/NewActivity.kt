package example.com.kotlin_android_api_tutorial.T04_Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val str = intent.getStringExtra("abc")
        Toast.makeText(this, "text : $str", Toast.LENGTH_SHORT).show()

        btnFinish.setOnClickListener {
            val resIntent = Intent()
            resIntent.putExtra("resValue", "hello world")
            setResult(Activity.RESULT_OK, resIntent)
            finish()
        }
    }
}
