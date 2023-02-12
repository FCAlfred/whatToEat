package com.freddev.whattoeat.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freddev.whattoeat.databinding.FragmentListadoPlatillosBinding
import com.freddev.whattoeat.model.Platillo
import com.freddev.whattoeat.view.adapter.PlatillosAdapter

class ListadoPlatillosFragment(
    private val platilloList: ArrayList<Platillo>
) : Fragment() {

    private var _binding: FragmentListadoPlatillosBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAdapter: PlatillosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListadoPlatillosBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        mAdapter = PlatillosAdapter(platilloList)
        binding.recyclerPlatillos.adapter = mAdapter
    }

    companion object {
        fun newInstance(platilloList: ArrayList<Platillo>) = ListadoPlatillosFragment(platilloList)
    }
}