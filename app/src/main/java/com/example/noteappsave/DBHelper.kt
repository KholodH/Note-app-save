package com.example.noteappsave

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,"details.db", null, 1) {
    private val sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table notes (pk INTEGER PRIMARY KEY AUTOINCREMENT, note text)")
        }
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        sqLiteDatabase!!.execSQL("DROP TABLE IF EXISTS notes")  // This removes the table if a new version is detected
        onCreate(sqLiteDatabase)
    }

    fun saveData(note: String): Long {
        val contentValues = ContentValues()
        // There is no need to pass in the pk because it is automatically generated
        contentValues.put("Note", note)
       var nt= sqLiteDatabase.insert("notes", null, contentValues)
        return nt
    }

}