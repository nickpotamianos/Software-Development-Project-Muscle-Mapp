package com.example.musclemapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = listOf(
        WelcomeFragment.newInstance(R.layout.welcome1),
        WelcomeFragment.newInstance(R.layout.welcome2),
        WelcomeFragment.newInstance(R.layout.welcome3)
    )

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? = null
}
