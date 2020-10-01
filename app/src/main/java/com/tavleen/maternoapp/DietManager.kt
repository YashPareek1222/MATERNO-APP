package com.tavleen.maternoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tavleen.maternoapp.adapters.viewPagerAdapter
import com.tavleen.maternoapp.fragments.Diet_FirstTrimester
import com.tavleen.maternoapp.fragments.Diet_SecondTrimester
import com.tavleen.maternoapp.fragments.Diet_ThirdTrimester
import kotlinx.android.synthetic.main.activity_diet_manager.*

class DietManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_manager)

        setupTabs()
    }

    private fun setupTabs() {
        val adapter = viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Diet_FirstTrimester(), "First Trimester")
        adapter.addFragment(Diet_SecondTrimester(), "Second Trimester")
        adapter.addFragment(Diet_ThirdTrimester(), "Third Trimester")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}