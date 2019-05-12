package example.com.kotlin_android_api_tutorial.T29_dagge2_3.model

import android.util.Log

open class CoffeeBean {
    open fun name(){
        Log.d("cafeinfo", "CoffeeBean")
    }
}

class EthiopiaBean: CoffeeBean() {
    override fun name(){
        Log.d("cafeinfo", "EthiopiaBean")
    }
}

class GuatemalaBean : CoffeeBean() {

    override fun name() {
        println("GuatemalaBean")
    }
}