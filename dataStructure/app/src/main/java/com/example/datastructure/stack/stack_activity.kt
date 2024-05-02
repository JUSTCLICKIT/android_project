package com.example.datastructure.stack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.datastructure.R
import java.util.*

class stack_activity : AppCompatActivity() {

    private val stack = Stack<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)

        val editTextElement = findViewById<EditText>(R.id.editTextElement)
        val btnInsert = findViewById<Button>(R.id.btnInsert)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        btnInsert.setOnClickListener {
            val element = editTextElement.text.toString().trim()
            if (element.isNotEmpty()) {
                stack.push(element)
                Toast.makeText(this, "Element inserted: $element", Toast.LENGTH_SHORT).show()
                editTextElement.text.clear()
            } else {
                Toast.makeText(this, "Please enter an element", Toast.LENGTH_SHORT).show()
            }
        }

        btnShow.setOnClickListener {
            val stackString = stack.joinToString(separator = " -> ", prefix = "Top -> ", postfix = " -> Bottom")
            Toast.makeText(this, "Stack: $stackString", Toast.LENGTH_LONG).show()
        }

        btnUpdate.setOnClickListener {
            val element = editTextElement.text.toString().trim()
            if (element.isNotEmpty()) {
                if (stack.isNotEmpty()) {
                    stack.pop()
                    stack.push(element)
                    Toast.makeText(this, "Element updated to: $element", Toast.LENGTH_SHORT).show()
                    editTextElement.text.clear()
                } else {
                    Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter an element", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            if (stack.isNotEmpty()) {
                val deletedElement = stack.pop()
                Toast.makeText(this, "Element deleted: $deletedElement", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
