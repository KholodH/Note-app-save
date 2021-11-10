package com.example.noteappsave

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,"details.db", null, 1) {
   // private val sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table notes (pk INTEGER PRIMARY KEY AUTOINCREMENT,noteid int,note text)")
    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS notes")  // This removes the table if a new version is detected
        onCreate(db)
    }

    fun saveData(note: NoteModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        // There is no need to pass in the pk because it is automatically generated
        contentValues.put("note",note.noteText)
       val nt= db.insert("notes", null, contentValues)
        db.close()
        return nt
    }

}
