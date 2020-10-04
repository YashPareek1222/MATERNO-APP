package com.tavleen.maternoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class dashboard : AppCompatActivity(){

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        btnlogoutsetOnclickListener()

        btndevelopment.setOnClickListener {
            startActivity(Intent(this, Development::class.java))
        }

        btntodo.setOnClickListener {
            startActivity(Intent(this, Todo::class.java))
        }

        btnworkout.setOnClickListener {
            startActivity(Intent(this, Workout::class.java))
        }

        btndiet.setOnClickListener {
            startActivity(Intent(this, DietManager::class.java))
        }

        btnmood.setOnClickListener {
            startActivity(Intent(this, MoodBooster::class.java))


        }
    }

        private fun btnlogoutsetOnclickListener() {
            btnlogout.setOnClickListener {
                mAuth.signOut()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

    }
