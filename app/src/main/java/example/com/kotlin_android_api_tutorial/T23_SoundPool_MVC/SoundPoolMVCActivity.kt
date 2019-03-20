package example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_sound_pool_mvc.*

class SoundPoolMVCActivity : AppCompatActivity() {

    lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_pool_mvc)

        beatBox = BeatBox(assets)

        recycler_view_sound.layoutManager = GridLayoutManager(this, 3)
        recycler_view_sound.adapter = SoundMVCAdapter(beatBox)
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }
}
