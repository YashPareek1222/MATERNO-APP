package com.tavleen.maternoapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_development.*
class Development : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_development)


        btnFirstTrimester.setOnClickListener {
            startActivity(Intent(this, FirstTrimester::class.java))
        }
        btnSecondTrimester.setOnClickListener {
            startActivity(Intent(this, SecondTrimester::class.java))
        }
        btnThirdTrimester.setOnClickListener {
            startActivity(Intent(this, ThirdTrimester::class.java))
        }
    }
}