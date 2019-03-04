package example.com.kotlin_android_api_tutorial.T12_Preference

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R

class PrefActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref)

        var pref = getSharedPreferences("mySettings", 0)
        val str = pref.getString("name", "default")
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        var pref = getSharedPreferences("mySettings", 0)
        var editor = pref.edit()
        editor.putString("name", "hello world")
        editor.commit()

    }
}
