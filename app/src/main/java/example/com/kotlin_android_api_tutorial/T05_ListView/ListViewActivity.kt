package example.com.kotlin_android_api_tutorial.T05_ListView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    val dataStr = arrayOf("hello", "world", "oracle", "java",
        "hello", "world", "oracle", "java",
        "hello", "world", "oracle", "java",
        "hello", "world", "oracle", "java")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataStr)
        myListView.adapter = adapter
        myListView.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this@ListViewActivity, dataStr[position], Toast.LENGTH_SHORT).show()
        }
    }
}
