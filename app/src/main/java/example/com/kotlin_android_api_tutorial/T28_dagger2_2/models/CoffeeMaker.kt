package example.com.kotlin_android_api_tutorial.T28_dagger2_2.models

import android.util.Log
import javax.inject.Inject

class CoffeeMaker(){

    @Inject lateinit var heater: Heater
    @Inject lateinit var pump: Pump

    // secondary constructor
    @Inject constructor(heater: Heater,pump: Pump): this(){
        this.heater = heater
        this.pump = pump
    }

    fun brew(){
        heater.on()
        pump.pump()
        Log.d("coffee", "coffee brewed!")
        heater.off()
    }
}