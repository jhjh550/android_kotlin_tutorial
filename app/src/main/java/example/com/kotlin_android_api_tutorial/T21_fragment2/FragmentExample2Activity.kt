package example.com.kotlin_android_api_tutorial.T21_fragment2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.T20_Fragment.ExampleFragment
import kotlinx.android.synthetic.main.activity_fragment_example2.*

class FragmentExample2Activity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example2)

        btnAdd.setOnClickListener(this)
        btnRemove.setOnClickListener(this)
        btnReplace.setOnClickListener(this)
        btnHide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var fr = supportFragmentManager.findFragmentById(R.id.frame)
        when(v?.id){
            R.id.btnAdd -> {
                if(fr == null){
                    fr = ExampleFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frame, fr, "counter")
                        .commit()
                }
            }
            R.id.btnRemove-> {
                if(fr != null){
                    supportFragmentManager.beginTransaction()
                        .remove(fr)
                        .commit()
                }
            }
            R.id.btnReplace -> {
                if(fr != null){
                    if(fr.tag == "counter"){
                        fr = TextFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame, fr, "text")
                            .commit()
                    }else{
                        fr = ExampleFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame, fr, "counter")
                            .commit()
                    }
                }
            }
            R.id.btnHide -> {
                if(fr != null){
                    if(fr.isHidden){
                        supportFragmentManager.beginTransaction()
                            .show(fr)
                            .commit()
                    }else{
                        supportFragmentManager.beginTransaction()
                            .hide(fr)
                            .commit()
                    }
                }
            }
        }
    }

}
