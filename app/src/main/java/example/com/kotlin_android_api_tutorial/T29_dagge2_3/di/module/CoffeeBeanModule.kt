package example.com.kotlin_android_api_tutorial.T29_dagge2_3.di.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.CoffeeBean
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.EthiopiaBean
import example.com.kotlin_android_api_tutorial.T29_dagge2_3.model.GuatemalaBean


@Module
abstract class CoffeeBeanModule {
    @Binds
    abstract fun provideCoffeeBean(ethiopiaBean: EthiopiaBean): CoffeeBean

    @Binds
    @IntoMap
    @StringKey("ethiopia")
    abstract fun provideEthiopiaBean(ethiopiaBean: EthiopiaBean): CoffeeBean


    @Binds
    @IntoMap
    @StringKey("guatemala")
    abstract fun provideGuatemalaBean(guatemalaBean: GuatemalaBean): CoffeeBean
    // EthiopiaBean 처럼 @Provide method 를 제공하지 않아도 @Inject annotation을 이용해 Injectable 한 객체로 정의해도 bind 가능.


}