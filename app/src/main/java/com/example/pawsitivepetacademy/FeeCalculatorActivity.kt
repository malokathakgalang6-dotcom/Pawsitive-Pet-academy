package com.example.pawsitivepetacademy

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeeCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fee_calculator)

        val cb1 = findViewById<CheckBox>(R.id.cb1)
        val cb2 = findViewById<CheckBox>(R.id.cb2)
        val cb3 = findViewById<CheckBox>(R.id.cb3)
        val cb4 = findViewById<CheckBox>(R.id.cb4)
        val cb5 = findViewById<CheckBox>(R.id.cb5)

        val txtSubtotal = findViewById<TextView>(R.id.txtSubtotal)
        val txtDiscount = findViewById<TextView>(R.id.txtDiscount)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        findViewById<TextView>(R.id.btnBackFromFees).setOnClickListener { finish() }

        findViewById<Button>(R.id.btnCalculate).setOnClickListener {
            var total = 0
            var count = 0

            if (cb1.isChecked) { total += 1500; count++ }
            if (cb2.isChecked) { total += 2500; count++ }
            if (cb3.isChecked) { total += 3500; count++ }
            if (cb4.isChecked) { total += 3000; count++ }
            if (cb5.isChecked) { total += 1200; count++ }

            if (count == 0) {
                Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var discount = 0
            if (count >= 2) {
                discount = (total * 0.10).toInt()
            }

            val finalTotal = total - discount

            txtSubtotal.text = "Subtotal: R$total"
            txtDiscount.text = "Discount: R$discount"
            txtTotal.text = "Total: R$finalTotal"
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            cb1.isChecked = false
            cb2.isChecked = false
            cb3.isChecked = false
            cb4.isChecked = false
            cb5.isChecked = false
            txtSubtotal.text = "Subtotal: R0"
            txtDiscount.text = "Discount: R0"
            txtTotal.text = "Total: R0"
        }
    }
}