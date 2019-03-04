package example.com.kotlin_android_api_tutorial.T13_SQLite

import android.content.ContentValues
import android.content.Context

class MyDBHandler {
    private lateinit var helper : MyOpenHelper

    constructor(context: Context) {
        helper = MyOpenHelper(context, null, null, 1)
    }

    fun insert(name:String, age:Int, address:String){
        var values = ContentValues()
        values.put("name", name)
        values.put("age", age)
        values.put("address", address)
        helper.writableDatabase.insert("student", null, values)
    }

    fun delete(name:String){
        helper.writableDatabase.delete("student", "name = ?", arrayOf(name))
    }

    fun update(name:String, newAge:Int){
        var values = ContentValues()
        values.put("age", newAge)
        helper.writableDatabase.update("student", values, "name = ?", arrayOf(name))
    }

    fun selectAll() : String{
        var res = ""
        val cursor = helper.readableDatabase.query("student", null, null, null, null, null, null)
        while(cursor.moveToNext()){
            val name = cursor.getString( cursor.getColumnIndex("name"))
            val age = cursor.getInt( cursor.getColumnIndex("age"))
            val address = cursor.getString( cursor.getColumnIndex("address"))

            res += "name : $name age : $age address : $address"
        }

        return res
    }
}