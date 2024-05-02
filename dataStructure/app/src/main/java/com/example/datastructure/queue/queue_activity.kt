package com.example.datastructure.queue

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.datastructure.R
import java.util.*

class queue_activity : AppCompatActivity() {

    private val queue = LinkedList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue)

        val editTextElement = findViewById<EditText>(R.id.editTextElement)
        val btnEnqueue = findViewById<Button>(R.id.btnEnqueue)
        val btnDequeue = findViewById<Button>(R.id.btnDequeue)
        val btnPeek = findViewById<Button>(R.id.btnPeek)
        val btnIsEmpty = findViewById<Button>(R.id.btnIsEmpty)

        btnEnqueue.setOnClickListener {
            val element = editTextElement.text.toString().trim()
            if (element.isNotEmpty()) {
                queue.offer(element)
                Toast.makeText(this, "Element enqueued: $element", Toast.LENGTH_SHORT).show()
                editTextElement.text.clear()
            } else {
                Toast.makeText(this, "Please enter an element", Toast.LENGTH_SHORT).show()
            }
        }

        btnDequeue.setOnClickListener {
            val element = queue.poll()
            if (element != null) {
                Toast.makeText(this, "Element dequeued: $element", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Queue is empty", Toast.LENGTH_SHORT).show()
            }
        }

        btnPeek.setOnClickListener {
            val element = queue.peek()
            if (element != null) {
                Toast.makeText(this, "Front element of the queue: $element", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Queue is empty", Toast.LENGTH_SHORT).show()
            }
        }

        btnIsEmpty.setOnClickListener {
            val isEmpty = queue.isEmpty()
            val message = if (isEmpty) "Queue is empty" else "Queue is not empty"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
