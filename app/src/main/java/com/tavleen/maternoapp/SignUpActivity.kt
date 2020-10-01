package com.tavleen.maternoapp
import java.util.Calendar;
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.*


class SignUpActivity : AppCompatActivity() {
    var picker: DatePickerDialog? = null
    var eText: EditText? = null
    var btnGet: Button? = null
    var tvw: TextView? = null

    private var email =""
    private var password=""


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        skipTextView.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        expectedDeliveryDate.setOnClickListener {
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)
            // date picker dialog
            // date picker dialog
            picker = DatePickerDialog(
                this@SignUpActivity,
                { view, year, monthOfYear, dayOfMonth -> expectedDeliveryDate!!.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day
            )
            picker!!.show()

        }

        auth = FirebaseAuth.getInstance()


        signupButton.setOnClickListener {

            email=emailEditText.text.toString().trim()
            password=passwordEditText.text.toString()
            checkuser()
        }

    }

    private fun checkuser() {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(email)) {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@SignUpActivity, "User Registered ", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,dashboard::class.java))
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this@SignUpActivity, "SignUp failed", Toast.LENGTH_SHORT).show()

                    }
                }
        }


        else {
            Toast.makeText(this@SignUpActivity, "Enter Correct credentials", Toast.LENGTH_SHORT).show()
        }
    }
}

// initial commit only
// git init - to initialize the repo in local system
//git remote add origin (link) - to connect local repo with github repo
// git add . - to add all the component of project to github
// git commit -m "(name of commit)" - to make a commit into github repo
// git push origin master - to push all the commit into repo

// after initial commit
// git add . - to add all the component of project to github
// git commit -m "(name of commit)" - to make a commit into github repo
// git push origin master - to push all the commit into repo
//these are all commands to be used

// cd (folder name) - to go into a folder
// cd .. - to go back
// do not add  a readme at the starting of project

// solution to not fast forward error
//git fetch origin master:tmp
//git rebase tmp
//git push origin HEAD:master
//git branch -D tmp