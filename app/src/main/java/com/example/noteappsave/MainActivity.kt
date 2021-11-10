package com.example.noteappsave

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var note = ""
    private lateinit var db: DatabaseHelper
    lateinit var btn:Button
    lateinit var tvadd:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btn= findViewById(R.id.button)
         tvadd= findViewById(R.id.editText)
        db = DatabaseHelper(this)
        btn.setOnClickListener {
            postNote()
        }


    }
    private fun postNote(){
        db.saveData(NoteModel(0, tvadd.text.toString()))
        tvadd.text.clear()
        Toast.makeText(this, "Note Added", Toast.LENGTH_LONG).show()
    }
}
