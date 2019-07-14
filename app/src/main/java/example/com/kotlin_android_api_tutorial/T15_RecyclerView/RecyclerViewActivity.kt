package example.com.kotlin_android_api_tutorial.T15_RecyclerView

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import example.com.kotlin_android_api_tutorial.R

import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    val arr = arrayOf(
        MyData("Chapter one", "Desc one", R.drawable.android_image_1),
        MyData("Chapter two", "Desc two", R.drawable.android_image_2),
        MyData("Chapter three", "Desc three", R.drawable.android_image_3),
        MyData("Chapter four", "Desc four", R.drawable.android_image_4),
        MyData("Chapter five", "Desc five", R.drawable.android_image_5),
        MyData("Chapter six", "Desc six", R.drawable.android_image_6),
        MyData("Chapter seven", "Desc seven", R.drawable.android_image_7),
        MyData("Chapter eight", "Desc eight", R.drawable.android_image_8),

        MyData("Chapter one", "Desc one", R.drawable.android_image_1),
        MyData("Chapter two", "Desc two", R.drawable.android_image_2),
        MyData("Chapter three", "Desc three", R.drawable.android_image_3),
        MyData("Chapter four", "Desc four", R.drawable.android_image_4),
        MyData("Chapter five", "Desc five", R.drawable.android_image_5),
        MyData("Chapter six", "Desc six", R.drawable.android_image_6),
        MyData("Chapter seven", "Desc seven", R.drawable.android_image_7),
        MyData("Chapter eight", "Desc eight", R.drawable.android_image_8),

        MyData("Chapter one", "Desc one", R.drawable.android_image_1),
        MyData("Chapter two", "Desc two", R.drawable.android_image_2),
        MyData("Chapter three", "Desc three", R.drawable.android_image_3),
        MyData("Chapter four", "Desc four", R.drawable.android_image_4),
        MyData("Chapter five", "Desc five", R.drawable.android_image_5),
        MyData("Chapter six", "Desc six", R.drawable.android_image_6),
        MyData("Chapter seven", "Desc seven", R.drawable.android_image_7),
        MyData("Chapter eight", "Desc eight", R.drawable.android_image_8)

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = RecyclerAdapter11(arr)
    }
}
