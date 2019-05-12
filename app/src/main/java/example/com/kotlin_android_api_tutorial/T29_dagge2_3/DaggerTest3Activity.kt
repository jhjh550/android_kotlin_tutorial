package example.com.kotlin_android_api_tutorial.T29_dagge2_3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.Component.DaggerCafeComponent
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module.CafeModule



class DaggerTest3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_dagger_test3)

        // Singleton Scope
//        val cafeComponent = DaggerCafeComponent.create()
        val cafeComponent = DaggerCafeComponent.builder()
            .cafeModule(CafeModule("example cafe"))
            .build()

        cafeComponent.cafeInfo().welcome()

        val cafe1 = cafeComponent.cafeInfo()
        val cafe2 = cafeComponent.cafeInfo()
        Log.d("cafeinfo", "Singleton scope CafeInfo is equal ${cafe1.equals(cafe2)}")

        // CoffeeScope
        val coffeeComponent1 = cafeComponent.coffeeComponent().build()
        val coffeeComponent2 = cafeComponent.coffeeComponent().build()
        val coffeeMaker1 = coffeeComponent1.coffeeMaker()
        val coffeeMaker2 = coffeeComponent1.coffeeMaker()
        Log.d("cafeinfo","Maker scope / same component coffeeMaker is equal : " +
                coffeeMaker1.equals(coffeeMaker2))

        val coffeeMaker3 = coffeeComponent2.coffeeMaker()
        Log.d("cafeinfo","Maker scope / different component coffeeMaker is equal : " +
                coffeeMaker1.equals(coffeeMaker3))

        // Non-Scope
        val coffeeBean1 = coffeeComponent1.coffeeBean()
        val coffeeBean2 = coffeeComponent1.coffeeBean()
        Log.d("cafeinfo","Non-scoped coffeebean is equal : " +
                coffeeBean1.equals(coffeeBean2));


        val coffeeComponent = DaggerCafeComponent.create().coffeeComponent().build()
        coffeeComponent.coffeeBeanMap().get("guatemala")?.name()

    }
}
