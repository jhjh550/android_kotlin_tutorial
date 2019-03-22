package example.com.kotlin_android_api_tutorial.T25_Json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import org.json.JSONObject
import org.json.JSONArray
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class JsonActivity : AppCompatActivity() {

    var str = "[{'name':'kim', 'tel':'010-1111-2222', 'age':20}," +
            "{'name':'park', 'tel':'010-2222-3333', 'age':21}," +
            "{'name':'lee', 'tel':'010-3333-4444', 'age':22}]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_json)

//        jsonParsing()
        jsonParsingWithGson()
    }

    fun jsonParsing(){
        var myList = ArrayList<JsonDTO>()
        val array = JSONArray(str)
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            val name = obj.getString("name")
            val tel = obj.getString("tel")
            val age = obj.getInt("age")

//            Log.d("json", "$name $tel $age")

            val myData = JsonDTO(name, tel, age)
            myList.add(myData)

            Log.d("json", myData.toString())
        }
    }

    fun jsonParsingWithGson(){
        val result = Gson().fromJson(str,Array<JsonDTO>::class.java)
        for(info in result){
            Log.d("json", info.toString())
        }
    }
}
