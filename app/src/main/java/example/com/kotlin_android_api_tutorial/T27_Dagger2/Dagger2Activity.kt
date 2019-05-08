package example.com.kotlin_android_api_tutorial.T27_Dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.T27_Dagger2.di.component.DaggerPetComponent
import example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module.CatModule
import example.com.kotlin_android_api_tutorial.T27_Dagger2.di.module.DogModule
import example.com.kotlin_android_api_tutorial.T27_Dagger2.models.Cat
import example.com.kotlin_android_api_tutorial.T27_Dagger2.models.Dog
import kotlinx.android.synthetic.main.activity_dagger2.*
import javax.inject.Inject

class Dagger2Activity : AppCompatActivity() {

    @Inject
    lateinit var cat : Cat

    @Inject
    lateinit var dog : Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2)

        injectComponent()

        catNameButton.setOnClickListener {
            catNameText.text = cat.name
        }
        dogNameButton.setOnClickListener {
            dogNameText.text = dog.name
        }


    }

    private fun injectComponent(){
        DaggerPetComponent.builder()
            .catModule(CatModule)
            .dogModule(DogModule)
            .build()
            .inject(this)
    }
}
