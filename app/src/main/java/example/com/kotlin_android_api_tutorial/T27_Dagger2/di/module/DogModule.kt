package example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module

import dagger.Module
import dagger.Provides
import example.com.kotlin_android_api_tutorial.T27_Dagger2.models.Dog



@Module
object DogModule {

    @Provides
    fun provideDog(): Dog {
        return Dog()
    }
}