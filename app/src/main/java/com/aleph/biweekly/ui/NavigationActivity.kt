package com.aleph.biweekly.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aleph.biweekly.databinding.ActivityNavigationBinding
import com.aleph.biweekly.ui.main.MainActivity

class NavigationActivity : AppCompatActivity(){

    private val binding by lazy {
        ActivityNavigationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            navigateKotlinPlayground.setOnClickListener { navigateToMainActivity(NavigationType.KOTLIN_PLAYGROUND) }
            navigateToConstraintLayout.setOnClickListener { navigateToMainActivity(NavigationType.CONSTRAINT_LAYOUT) }
            navigateToMotionLayout.setOnClickListener { navigateToMainActivity(NavigationType.MOTION_LAYOUT) }
        }
    }

    private fun navigateToMainActivity(navigationType: NavigationType){
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra(NAVIGATION_TYPE_KEY, navigationType)
            }
        )
    }

    companion object{

        enum class NavigationType{
            CONSTRAINT_LAYOUT,
            MOTION_LAYOUT,
            KOTLIN_PLAYGROUND
        }

        const val NAVIGATION_TYPE_KEY = "NAVIGATION_TYPE_KEY"
    }
}