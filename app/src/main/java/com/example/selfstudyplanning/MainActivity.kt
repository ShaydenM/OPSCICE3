package com.example.selfstudyplanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {

    //declare buttons
    private lateinit var btnModuleScreen : Button
    private lateinit var tbnLogTimeScreen : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize buttons
        tbnLogTimeScreen = findViewById(R.id.tbnLogTimeScreen)
        btnModuleScreen = findViewById(R.id.btnModuleScreen)

        //set what happens when a button is clicked
        tbnLogTimeScreen.setOnClickListener{
          val i = Intent(this, LogTimeActivity::class.java)
          startActivity(i)
            finish()

        }

        btnModuleScreen.setOnClickListener{
            val intent = Intent(this, ModuleActivity::class.java)
            startActivity(intent)
            finish()


        }


    }
}