package example.com.kotlin_android_api_tutorial.T30_VideoView

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_videoview.*


class VideoViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_videoview)

//        val controller = MediaController(this)
//        controller.setAnchorView(videoView)
//        videoView.setMediaController(controller)

        btnStart.setOnClickListener {
            start()
        }
        videoView.setOnClickListener {
            hideSystemBar()
        }
    }

//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        if(hasFocus){
//            hideSystemBar()
//        }
//    }

    //https://developer.android.com/training/system-ui/immersive

    fun hideSystemBar() {
        window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
    }



    private fun start() {
        hideSystemBar()

        val uriPath =
            "https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4" //update package name
        val uri = Uri.parse(uriPath)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
        videoView.setOnInfoListener { mp, what, extra ->
            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                hideSystemBar()
                return@setOnInfoListener true
            }
            return@setOnInfoListener false
        }
    }
}