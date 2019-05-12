package example.com.kotlin_android_api_tutorial.T29_dagge2_3.model

import android.util.Log

class CafeInfo() {
    constructor(name:String): this(){
        this.name = name
    }

    private var name = ""
    fun welcome(){
        Log.d("cafeinfo", "Welcome "+name)
    }
}