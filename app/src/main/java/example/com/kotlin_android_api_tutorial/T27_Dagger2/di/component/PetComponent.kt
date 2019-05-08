package example.com.kotlin_android_api_tutorial.T27_Dagger2.di.component

import dagger.Component
import example.com.kotlin_android_api_tutorial.T27_Dagger2.Dagger2Activity
import example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module.CatModule
import example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module.DogModule
import javax.inject.Singleton

@Singleton
@Component(modules = [DogModule::class, CatModule::class])
interface PetComponent {

    fun inject(dagger2Activity:Dagger2Activity)

    @Component.Builder
    interface Builder{
        fun build() : PetComponent

        fun dogModule(dogModule: DogModule) : Builder
        fun catModule(catModule: CatModule) : Builder
    }
}