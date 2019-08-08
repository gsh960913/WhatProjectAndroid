package com.smcompony.what

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TabPagerAdapter2(fm: FragmentManager, private val tabCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> {
                return TabFragment1()
            }
            1 -> {
                return TabFragment3()
            }
            2 -> {
                return TabFragment2()
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
