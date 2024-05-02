package com.example.datastructure

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.example.datastructure.array.array_activity
import com.example.datastructure.queue.queue_activity
//import com.example.datastructure.array.com.example.datastructure.array.array_activity
//import com.example.datastructure.queue.com.example.datastructure.queue.queue_activity
//import com.example.datastructure.stack.com.example.datastructure.stack.stack_activity
import com.example.datastructure.stack.stack_activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnStack)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnArray: Button = findViewById(R.id.btnArray)
        btnArray.setOnClickListener {
            startActivity(Intent(this, array_activity::class.java))
        }

        val btnStack: Button = findViewById(R.id.btnStack)
        btnStack.setOnClickListener {
            startActivity(Intent(this, stack_activity::class.java))
        }

        val btnQueue: Button = findViewById(R.id.btnQueue)
        btnQueue.setOnClickListener {
            startActivity(Intent(this, queue_activity::class.java))
        }
    }
}
