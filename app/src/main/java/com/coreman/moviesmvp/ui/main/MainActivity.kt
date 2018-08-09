package com.coreman.moviesmvp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.coreman.moviesmvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
