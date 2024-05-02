package com.example.datastructure.array

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.datastructure.R
import java.util.*

class array_activity : AppCompatActivity() {

    private val array = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)

        val editTextIndex = findViewById<EditText>(R.id.editTextIndex)
        val editTextElement = findViewById<EditText>(R.id.editTextElement)
        val btnInsert = findViewById<Button>(R.id.btnInsert)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        btnInsert.setOnClickListener {
            val index = editTextIndex.text.toString().toIntOrNull()
            val element = editTextElement.text.toString().trim()
            if (index != null && element.isNotEmpty()) {
                array.add(index, element)
                Toast.makeText(this, "Element inserted at index $index: $element", Toast.LENGTH_SHORT).show()
                editTextIndex.text.clear()
                editTextElement.text.clear()
            } else {
                Toast.makeText(this, "Please enter valid index and element", Toast.LENGTH_SHORT).show()
            }
        }

        btnShow.setOnClickListener {
            val arrayString = array.joinToString(separator = ", ", prefix = "[", postfix = "]")
            Toast.makeText(this, "Array: $arrayString", Toast.LENGTH_LONG).show()
        }

        btnUpdate.setOnClickListener {
            val index = editTextIndex.text.toString().toIntOrNull()
            val element = editTextElement.text.toString().trim()
            if (index != null && element.isNotEmpty() && index >= 0 && index < array.size) {
                array[index] = element
                Toast.makeText(this, "Element at index $index updated to: $element", Toast.LENGTH_SHORT).show()
                editTextIndex.text.clear()
                editTextElement.text.clear()
            } else {
                Toast.makeText(this, "Please enter valid index and element", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            val index = editTextIndex.text.toString().toIntOrNull()
            if (index != null && index >= 0 && index < array.size) {
                val deletedElement = array.removeAt(index)
                Toast.makeText(this, "Element at index $index deleted: $deletedElement", Toast.LENGTH_SHORT).show()
                editTextIndex.text.clear()
            } else {
                Toast.makeText(this, "Please enter a valid index", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
