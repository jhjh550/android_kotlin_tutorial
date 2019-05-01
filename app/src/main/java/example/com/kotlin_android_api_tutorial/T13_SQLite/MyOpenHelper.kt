package example.com.kotlin_android_api_tutorial.T13_SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper(context: Context,
                   factory: SQLiteDatabase.CursorFactory?, version: Int)
                        : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql =
            "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, age INTEGER, address TEXT)"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS student"
        db.execSQL(sql)

        onCreate(db)

    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "people.db"

    }
}

