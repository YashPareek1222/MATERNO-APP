package com.tavleen.maternoapp
import java.util.Calendar;
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.*


class SignUpActivity : AppCompatActivity() {
    var picker: DatePickerDialog? = null
    var eText: EditText? = null
    var btnGet: Button? = null
    var tvw: TextView? = null
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