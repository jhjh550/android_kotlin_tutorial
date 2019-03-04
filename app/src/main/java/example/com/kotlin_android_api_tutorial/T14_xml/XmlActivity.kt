package example.com.kotlin_android_api_tutorial.T14_xml

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_xml.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL




class XmlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_xml)

        MyXmlTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153054000")
    }

    inner class MyXmlTask : AsyncTask<String, Void, String>(){

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            xmlTextView.text = result
        }

        override fun doInBackground(vararg params: String?): String {
            var res = ""

            val path = params[0]
            val url = URL(path)
            val factory = XmlPullParserFactory.newInstance()
            val xpp = factory.newPullParser()
            xpp.setInput(url.openStream(), "utf-8")

            var bRead = false
            var eventType = xpp.eventType
            while(eventType != XmlPullParser.END_DOCUMENT){
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        val tag = xpp.name
                        if (tag == "hour" || tag == "day"
                            || tag == "temp" || tag == "wfKor"
                        ) {
                            bRead = true
                        }
                    }

                    XmlPullParser.TEXT -> if (bRead) {
                        res += xpp.text + " "
                        bRead = false
                    }
                }

                eventType = xpp.next()
            }

            return res
        }
    }
}
