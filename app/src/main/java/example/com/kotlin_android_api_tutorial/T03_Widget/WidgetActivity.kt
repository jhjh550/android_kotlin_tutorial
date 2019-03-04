package example.com.kotlin_android_api_tutorial.T03_Widget

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_widget.*


class WidgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(example.com.kotlin_android_api_tutorial.R.layout.activity_widget)

        myCheckBox.setOnCheckedChangeListener{ buttonView, isChecked ->
            Toast.makeText(this@WidgetActivity, "Checked $isChecked", Toast.LENGTH_SHORT).show()
        }

        myRadioGroup.setOnCheckedChangeListener{group, checkedId ->
            when (checkedId) {
                R.id.myRadio1 -> Toast.makeText(this@WidgetActivity, "radio1 selected", Toast.LENGTH_SHORT).show()
                R.id.myRadio2 -> Toast.makeText(this@WidgetActivity, "radio2 selected", Toast.LENGTH_SHORT).show()
                R.id.myRadio3 -> Toast.makeText(this@WidgetActivity, "radio3 selected", Toast.LENGTH_SHORT).show()
            }
        }

        btnOK.setOnClickListener {
            val str = "text : " + myEditText.text.toString()
            Toast.makeText(this@WidgetActivity, str, Toast.LENGTH_SHORT).show()
            myEditText.setText("")
        }
    }
}
