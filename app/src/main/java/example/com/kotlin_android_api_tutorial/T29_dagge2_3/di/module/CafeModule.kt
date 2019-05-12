package example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module

import dagger.Module
import dagger.Provides
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.Component.CoffeeComponent
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CafeInfo
import javax.inject.Singleton

@Module(subcomponents = [CoffeeComponent::class])
class CafeModule (){
    constructor(name:String): this(){
        this.name = name
    }

    private var name:String = ""

    @Singleton
    @Provides
    fun provideCafeInfo(): CafeInfo{
        if(name.isEmpty())
            return CafeInfo()
        else
            return CafeInfo(name)
    }
//
//    @Provides
//    fun provideCoffeeMaker(heater: Heater): CoffeeMaker {
//        return CoffeeMaker(heater)
//    }
//
//    @Provides
//    fun provideHeater(): Heater{
//        return A_Heater()
//    }
}