package com.freddev.whattoeat.view.fragment.cena

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freddev.whattoeat.R

class CenasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cenas, container, false)
    }

    companion object {
        fun newInstance() = CenasFragment()
    }
}