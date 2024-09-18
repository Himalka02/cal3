package com.example.cal3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editTextNum1 = findViewById<EditText>(R.id.editTextNum1)
        val editTextNum2 = findViewById<EditText>(R.id.editTextNum2)
        val addbutton = findViewById<Button>(R.id.addbutton)
        val substractbutton = findViewById<Button>(R.id.substractbutton)
        val multiplybutton = findViewById<Button>(R.id.multiplybutton)
        val dividebutton = findViewById<Button>(R.id.dividebutton)
        val result = findViewById<TextView>(R.id.result)

        addbutton.setOnClickListener {
            calculate("+", editTextNum1.text.toString(), editTextNum2.text.toString(), result)
        }

        substractbutton.setOnClickListener {
            calculate("-", editTextNum1.text.toString(), editTextNum2.text.toString(), result)
        }

        multiplybutton.setOnClickListener {
            calculate("*", editTextNum1.text.toString(), editTextNum2.text.toString(), result)
        }

        dividebutton.setOnClickListener {
            calculate("/", editTextNum1.text.toString(), editTextNum2.text.toString(), result)
        }
    }

    fun calculate(operation: String, num1: String, num2: String, resultView: TextView) {
        if (num1.isEmpty() || num2.isEmpty()) {
            resultView.text = "Please enter both numbers"
            return
        }

        val number1 = num1.toDoubleOrNull()
        val number2 = num2.toDoubleOrNull()

        if (number1 == null || number2 == null) {
            resultView.text = "Invalid input"
            return
        }

        val result = when (operation) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
            else -> "Unknown operation"
        }

        resultView.text = "Result: $result"
    }
}