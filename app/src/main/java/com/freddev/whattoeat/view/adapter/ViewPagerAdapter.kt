package com.freddev.whattoeat.view.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    private val fragmentList: ArrayList<Fragment>,
    private val activity: AppCompatActivity
    /*cuando se crea en unFragmento, en lugar de recibir un AppCompatActivity
    recibiría un tipo Fragment*/
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}