package com.freddev.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.freddev.whattoeat.databinding.ActivityMainBinding
import com.freddev.whattoeat.view.adapter.ViewPagerAdapter
import com.freddev.whattoeat.view.fragment.comida.ComidasFragment
import com.freddev.whattoeat.view.fragment.cena.CenasFragment
import com.freddev.whattoeat.view.fragment.desayuno.DesayunosFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragments: ArrayList<Fragment>
    private lateinit var arrayDots: MutableList<ImageView>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initComponents()
        binding.viewPagerMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateSelectedPage(position)
            }
        })
    }

    private fun initComponents() {
        arrayDots = mutableListOf()
        fragments = arrayListOf(
            DesayunosFragment.newInstance(),
            ComidasFragment.newInstance(),
            CenasFragment.newInstance()
        )

        for (i in 0 until fragments.size) {
            val imageDot = ImageView(this)
            val icon = if ((i == 0)) {
                R.drawable.active_page_dot
            } else {
                R.drawable.inactive_page_dot
            }
            imageDot.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    icon
                )
            )
            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutParams.setMargins(20, 0, 0, 0)
            val mAdapter = ViewPagerAdapter(fragments, this)
            arrayDots.add(imageDot)
            binding.apply {
                viewPagerMain.adapter = mAdapter
                linearDotsIndicatorPage.addView(imageDot, layoutParams)
            }
        }
    }

    private fun updateSelectedPage(position: Int) {
        arrayDots.forEachIndexed { index, imageView ->
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    if (index != position) {
                        R.drawable.inactive_page_dot
                    } else {
                        R.drawable.active_page_dot
                    }
                )
            )
        }
    }
}