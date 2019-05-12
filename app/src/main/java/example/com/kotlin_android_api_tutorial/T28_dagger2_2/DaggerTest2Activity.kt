package example.com.kotlin_android_api_tutorial.T28_dagger2_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.di.DaggerCoffeeComponent

import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.CoffeeMaker


class DaggerTest2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_test2)

        dagger_di_property()
    }

    fun dagger_di_property(){
        val coffeeMaker = CoffeeMaker()
        DaggerCoffeeComponent.create().inject(coffeeMaker)
        coffeeMaker.brew()


    }


    fun dagger_di_constructor(){
//        Injection.provideCoffeeMaker().brew()
    }

    fun defency_injection(){
//        DaggerCoffeeComponent.create().make().brew()
    }

    fun default_login(){
//        val heater = A_Heater()
//        val pump = A_Pump(heater)
//        val coffeMaker = CoffeeMaker(heater, pump)
//        coffeMaker.brew()
    }
}
