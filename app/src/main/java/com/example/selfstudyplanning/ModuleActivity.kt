package com.example.selfstudyplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.firebase.firestore.FirebaseFirestore

class ModuleActivity : AppCompatActivity() {

    private lateinit var moduleNameEt : EditText
    private lateinit var btnBack : Button
    private lateinit var btnAddModule : Button
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_module)

        moduleNameEt = findViewById(R.id.moduleNameEt)
        btnBack = findViewById(R.id.btnBack)
        btnAddModule = findViewById(R.id.btnAddModule)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        btnAddModule.setOnClickListener {
            val moduleName = moduleNameEt.text.toString().trim()
            if (moduleName.isNotEmpty()) {
                saveModule(moduleName)

            }

        }
    }
        private fun saveModule(name : String) {
            val module = hashMapOf("name" to name)
            db.collection("modules").add(module).addOnSuccessListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                moduleNameEt.setText("")

            }

        }


}