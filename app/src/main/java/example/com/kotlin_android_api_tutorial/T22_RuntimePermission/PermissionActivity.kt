package example.com.kotlin_android_api_tutorial.T22_RuntimePermission

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Log
import example.com.kotlin_android_api_tutorial.R
import java.util.jar.Manifest

class PermissionActivity : AppCompatActivity() {

    private val TAG = "Permission"
    private val PERMISSION_REQ_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        setupPermissions()
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE)
        if(permission != PackageManager.PERMISSION_GRANTED){
            Log.i(TAG, "Permission to read external storage denied")

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)){

                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permission to read external storage is required for this app.")
                    .setTitle("Permission required")
                    .setPositiveButton("OK"){ dialog, which ->
                        Log.i(TAG, "clicked")
                        makeRequest()
                    }
                    val dlg = builder.create()
                    dlg.show()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQ_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_REQ_CODE ->{
                if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Log.i(TAG, "Permission has been denied by user")
                }else{
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }
}
