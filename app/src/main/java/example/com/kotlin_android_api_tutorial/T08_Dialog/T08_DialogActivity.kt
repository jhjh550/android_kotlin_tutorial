package example.com.kotlin_android_api_tutorial.T08_Dialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.RatingBar
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_activity.*
import kotlinx.android.synthetic.main.activity_t08__dialog.*

class T08_DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t08__dialog)

        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_view, null)
        val dialogText = dialogView.findViewById<EditText>(R.id.dialogEt)
        val dialogRatingBar = dialogView.findViewById<RatingBar>(R.id.dialogRb)

        builder.setView(dialogView)
            .setPositiveButton("OK"){ dialog, which ->
                mainTv.text = dialogText.text
                mainRb.rating = dialogRatingBar.rating
            }
            .setNegativeButton("Cancel"){ dialog, which ->

            }
            .show()

    }
}
