package example.com.kotlin_android_api_tutorial

import android.databinding.BaseObservable
import android.databinding.Bindable
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.BeatBox
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.Sound

class SoundViewModel(private val beatBox: BeatBox): BaseObservable() {

    var sound: Sound? = null
        set(value){
            field = value
            notifyChange()
        }


    val title: String?
        @Bindable
        get(){
            return sound?.name
        }

    fun onButtonClicked(){
        if(sound != null)
            beatBox.play(sound!!)
    }
}