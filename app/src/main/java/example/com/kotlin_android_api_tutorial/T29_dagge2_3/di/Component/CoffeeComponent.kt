package example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.Component

import dagger.Subcomponent
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module.CoffeeBeanModule
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module.CoffeeModule
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CoffeeBean
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CoffeeMaker




annotation class CoffeeScope

@CoffeeScope
@Subcomponent(modules = [CoffeeModule::class, CoffeeBeanModule::class])
interface CoffeeComponent {
    fun coffeeMaker(): CoffeeMaker
    fun coffeeBean(): CoffeeBean
    fun coffeeBeanMap(): Map<String, CoffeeBean>


    @Subcomponent.Builder
    interface Builder{
        fun build(): CoffeeComponent
        fun coffeeModule(coffeeModule: CoffeeModule): Builder
    }

}





