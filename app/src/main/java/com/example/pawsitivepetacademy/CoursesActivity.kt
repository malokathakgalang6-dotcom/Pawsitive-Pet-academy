package com.example.pawsitivepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        findViewById<TextView>(R.id.btnBackFromCourses).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnGoToFees).setOnClickListener {
            startActivity(Intent(this, FeeCalculatorActivity::class.java))
        }
    }
}