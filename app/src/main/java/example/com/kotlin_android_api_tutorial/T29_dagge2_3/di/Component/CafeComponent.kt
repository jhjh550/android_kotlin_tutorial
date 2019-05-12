package example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.Component

import dagger.Component
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module.CafeModule
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CafeInfo
import javax.inject.Singleton

@Singleton
@Component(modules = [CafeModule::class])
interface CafeComponent {
    fun cafeInfo(): CafeInfo
    fun coffeeComponent(): CoffeeComponent.Builder

    @Component.Builder
    interface Builder{
        fun cafeModule(cafeModule: CafeModule): Builder
        fun build(): CafeComponent
    }

}