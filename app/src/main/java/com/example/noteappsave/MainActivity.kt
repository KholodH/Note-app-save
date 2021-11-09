package com.example.noteappsave

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var note = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn= findViewById<Button>(R.id.button)
        var tvadd= findViewById<EditText>(R.id.editText)

        btn.setOnClickListener {
            note=tvadd.text.toString()
            var dbhr=DatabaseHelper(applicationContext)
           var nt= dbhr.saveData(note)
            Toast.makeText(applicationContext,"data saved"+nt,Toast.LENGTH_SHORT).show()
        }


    }
}