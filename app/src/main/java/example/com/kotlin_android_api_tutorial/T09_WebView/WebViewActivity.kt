package example.com.kotlin_android_api_tutorial.T09_WebView

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)


        myWebView.webViewClient = object:WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                pageLoadProgressBar.progress = 0
                pageLoadProgressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                pageLoadProgressBar.visibility = View.GONE
            }
        }
        myWebView.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                pageLoadProgressBar.progress = newProgress
            }
        }

        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("http://daum.net")

    }

    override fun onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack()
        }else {
            super.onBackPressed()
        }
    }
}
