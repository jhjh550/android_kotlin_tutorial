package example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module

import dagger.Module
import dagger.Provides
import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.A_Heater

import example.com.kotlin_android_api_tutorial.T28_dagger2_2.models.Heater
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.Component.CoffeeScope
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CoffeeBean
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CoffeeMaker
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.EthiopiaBean
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.GuatemalaBean


@Module
class CoffeeModule {

    @CoffeeScope
    @Provides
    fun provideCoffeeMaker(heater: Heater): CoffeeMaker {
        return CoffeeMaker(heater)
    }

    @CoffeeScope
    @Provides
    fun provideHeater(): Heater{
        return A_Heater()
    }

//    @Provides
//    fun provideCoffeeBean(): CoffeeBean{
//        return CoffeeBean()
//    }

    // 타입에 맞춰 생성될 객체가 명확할 때는 GuatemalaBean 처럼 @Inject 형태로도 가능. 그렇지 않으면 @Provide method를 만들어주어야 함.
    @Provides
    fun provideEthiopiaBean(): EthiopiaBean {
        return EthiopiaBean()
    }

    @Provides
    fun provideGuatemalaBean(): GuatemalaBean {
        return GuatemalaBean()
    }
}