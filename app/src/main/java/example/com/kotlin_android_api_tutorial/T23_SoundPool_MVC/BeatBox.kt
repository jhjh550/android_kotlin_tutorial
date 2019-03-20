package example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC

import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log
import java.lang.Exception

class BeatBox(private val assetManager: AssetManager) {
    private val TAG = "BeatBox"
    private val SOUNDS_FOLDER = "sample_sounds"
    private val MAX_SOUNDS = 5

    val sounds = ArrayList<Sound>()
    private lateinit var soundPool : SoundPool

    init {
        soundPool = SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0)
        loadSounds()
    }

    private fun loadSounds(){
        val soundNames = assetManager.list(SOUNDS_FOLDER)
        for(fileName in soundNames){
            val assetPath = SOUNDS_FOLDER+"/"+fileName
            val sound = Sound(assetPath)
            load(sound)
            sounds.add(sound)
        }

    }

    private fun load(sound: Sound){
        val afd = assetManager.openFd(sound.assetPath)
        sound.soundId = soundPool.load(afd, 1)
    }

    fun play(sound: Sound){
        soundPool.play(sound.soundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    fun release(){
        soundPool.release()
    }

}