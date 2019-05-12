package example.com.kotlin_android_api_tutorial.T28_dagger2_2.models

import android.util.Log

interface Pump {
    fun pump()
}

class A_Pump(private val heater: Heater): Pump{
    override fun pump() {
        Log.d("coffee", "A_Pump : pumping!!!")
    }

}