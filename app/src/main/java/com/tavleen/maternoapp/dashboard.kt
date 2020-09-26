package com.tavleen.maternoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class dashboard : AppCompatActivity() {

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        btnlogoutsetOnclickListener()
    }

    private fun btnlogoutsetOnclickListener() {

        btnlogout.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}

