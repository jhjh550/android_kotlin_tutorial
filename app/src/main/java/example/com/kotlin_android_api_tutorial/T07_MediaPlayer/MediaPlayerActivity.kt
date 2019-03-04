package example.com.kotlin_android_api_tutorial.T07_MediaPlayer

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayerActivity : AppCompatActivity(), View.OnClickListener {

    var mp : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        btnPlay.setOnClickListener(this)
        btnStop.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btnPlay){
            onMusicPlay()
        }else{
            onMusicStop()
        }
    }

    private fun onMusicPlay(){
        mp = MediaPlayer()
        mp?.setDataSource("http://www.hochmuth.com/mp3/Haydn_Cello_Concerto_D-1.mp3")
        mp?.prepare()
        mp?.start()
    }

    private fun onMusicStop(){
        mp?.stop()
        mp?.release()
        mp = null
    }

}
