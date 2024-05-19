package com.example.matule.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.matule.databinding.ActivityOnboardingBinding
import com.example.matule.ui.onboarding.fragments.OnboardingOneFragment
import com.example.matule.ui.onboarding.fragments.OnboardingThreeFragment
import com.example.matule.ui.onboarding.fragments.OnboardingTwoFragment

private lateinit var binding: ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = OnboardingAdapter(
            listOf(
                OnboardingOneFragment(),
                OnboardingTwoFragment(),
                OnboardingThreeFragment()
            ), supportFragmentManager, lifecycle
        )
        binding.pagerOnboarding.adapter = adapter

        binding.pagerOnboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> showIndicatorOne()
                    1 -> showIndicatorTwo()
                    2 -> showIndicatorThree()
                }
            }
        })

        binding.btn.setOnClickListener {
            if(binding.pagerOnboarding.currentItem != 2) {
                binding.pagerOnboarding.currentItem += 1
            } else {
                // todo next activity
            }
        }
    }

    private fun showIndicatorOne() {
        binding.iv1.visibility = View.VISIBLE
        binding.iv2.visibility = View.GONE
        binding.iv3.visibility = View.GONE
        binding.btn.text = "Начать"
    }

    private fun showIndicatorTwo() {
        binding.iv1.visibility = View.GONE
        binding.iv2.visibility = View.VISIBLE
        binding.iv3.visibility = View.GONE
        binding.btn.text = "Далее"
    }

    private fun showIndicatorThree() {
        binding.iv1.visibility = View.GONE
        binding.iv2.visibility = View.GONE
        binding.iv3.visibility = View.VISIBLE
        binding.btn.text = "Далее"
    }
}