package example.com.kotlin_android_api_tutorial.T24_SoundPool_MVVM

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.BeatBox
import example.com.kotlin_android_api_tutorial.databinding.ActivitySoundPoolMvvmBinding

class SoundPoolMVVMActivity : AppCompatActivity() {

    lateinit var binding: ActivitySoundPoolMvvmBinding
    lateinit var beatBox: BeatBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beatBox = BeatBox(assets)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sound_pool_mvvm)
        binding.recyclerViewSoundMvvm.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewSoundMvvm.adapter =
            SoundMVVMAdapter(beatBox)

    }
}
