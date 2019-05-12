package example.com.kotlin_android_api_tutorial.T28_dagger2_2.di

import dagger.Module
import dagger.Provides
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.A_Heater
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.A_Pump
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.Heater
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.Pump
import javax.inject.Inject

@Module
class CoffeeMakerModule {

    @Provides
    fun provideHeater(): Heater{
        return A_Heater()
    }

    @Provides
    fun providePump(heater: Heater): Pump {
        return A_Pump(heater)
    }


}