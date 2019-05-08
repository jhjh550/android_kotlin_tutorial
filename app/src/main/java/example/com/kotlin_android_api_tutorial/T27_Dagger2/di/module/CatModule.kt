package example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module

import dagger.Module
import dagger.Provides
import example.com.kotlin_android_api_tutorial.T27_Dagger2.models.Cat

@Module
object CatModule {

    @Provides
    fun provideCat(): Cat {
        return Cat()
    }
}