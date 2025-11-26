package com.example.visiterhaiti2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionF = findViewById<EditText>(R.id.user_question)
        val reponseF = findViewById<EditText>(R.id.user_reponse)
        val cancel_btn = findViewById<ImageView>(R.id.imageView3)
        val save_btn = findViewById<ImageView>(R.id.imageView4)

        cancel_btn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
        save_btn.setOnClickListener {
            val userquestion = questionF.text.toString()
            val userreponse = reponseF.text.toString()
            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "question_cle",
                "userquestion"
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "reponse_cle",
                "userreponse"
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish()

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}