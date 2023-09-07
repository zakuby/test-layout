package com.aleph.biweekly.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aleph.biweekly.R
import com.aleph.biweekly.ui.NavigationActivity
import com.aleph.biweekly.ui.NavigationActivity.Companion.NavigationType.CONSTRAINT_LAYOUT
import com.aleph.biweekly.ui.NavigationActivity.Companion.NavigationType.MOTION_LAYOUT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = when (viewModel.getNavigationType()) {
            CONSTRAINT_LAYOUT, MOTION_LAYOUT -> LayoutSampleFragment.newInstance()
            else -> KotlinPlaygroundFragment.newInstance()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
    }
}