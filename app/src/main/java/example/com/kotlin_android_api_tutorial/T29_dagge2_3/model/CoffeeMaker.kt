package example.com.kotlin_android_api_tutorial.T29_dagge2_3.model

import android.util.Log
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.Heater
import javax.inject.Inject

class CoffeeMaker @Inject constructor(val heater:Heater){
    fun brew(coffeeBean: CoffeeBean){
        Log.d("cafeinfo", "CoffeeBean ${coffeeBean.toString()} coffee brewed!")

    }
}