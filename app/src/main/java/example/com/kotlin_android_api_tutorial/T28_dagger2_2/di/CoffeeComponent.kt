package example.com.kotlin_android_api_tutorial.T28_dagger2_2.di

import dagger.Component
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.CoffeeMaker

@Component(modules = [CoffeeMakerModule::class])
interface CoffeeComponent{

    fun inject(coffeeMaker: CoffeeMaker)

    fun make(): CoffeeMaker

}