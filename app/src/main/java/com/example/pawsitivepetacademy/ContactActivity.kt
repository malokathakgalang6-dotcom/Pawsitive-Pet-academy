package com.example.pawsitivepetacademy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        findViewById<TextView>(R.id.btnBackFromContact).setOnClickListener { finish() }

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etMessage = findViewById<EditText>(R.id.etMessage)

        findViewById<Button>(R.id.btnSend).setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val message = etMessage.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) {
                Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thank you $name! Message sent.", Toast.LENGTH_LONG).show()
                etName.text.clear()
                etEmail.text.clear()
                etMessage.text.clear()
            }
        }
    }
}