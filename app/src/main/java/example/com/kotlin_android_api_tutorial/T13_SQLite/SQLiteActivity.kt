package example.com.kotlin_android_api_tutorial.T13_SQLite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_sqlite.*

class SQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        var dbHelper = MyDBHandler(this)
        dbHelper.insert("kim", 10, "seoul")
        dbHelper.insert("lee", 11, "busan")
        dbHelper.insert("park", 12, "인천")
        dbHelper.insert("hong", 13, "제주도")

        dbHelper.delete("lee")
        dbHelper.update("kim", 20)

        val res = dbHelper.selectAll()
        sqliteTextView.text = res


    }
}
