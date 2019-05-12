package example.com.kotlin_android_api_tutorial.T28_dagger2_2.models

import android.util.Log

interface Heater {
    fun on()
    fun off()
    fun isHot():Boolean
}

class A_Heater: Heater{
    private var heating = false
    override fun on() {
        Log.d("coffee", "A_Heater : heater is on")
        heating = true
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean {
        return heating
    }

}