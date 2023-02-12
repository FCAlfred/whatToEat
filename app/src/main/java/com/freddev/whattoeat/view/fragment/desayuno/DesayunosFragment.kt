package com.freddev.whattoeat.view.fragment.desayuno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.freddev.whattoeat.R
import com.freddev.whattoeat.databinding.FragmentDesayunosBinding
import com.freddev.whattoeat.model.Platillo
import com.freddev.whattoeat.model.PlatilloResponse
import com.freddev.whattoeat.view.fragment.ListadoPlatillosFragment
import com.google.gson.Gson
import java.io.IOException

class DesayunosFragment : Fragment() {

    private var _binding: FragmentDesayunosBinding? = null
    private val binding get() = _binding!!

    private lateinit var portada: String
    private lateinit var platilloList: ArrayList<Platillo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDesayunosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getData() {
        val gson = Gson()
        val json = loadLocalData("desayunos.json")
        val desayunosResponse = gson.fromJson(json, PlatilloResponse::class.java)
        portada = desayunosResponse.portada
        platilloList = desayunosResponse.platillo
    }

    private fun initView() {
        Glide.with(requireContext()).load(portada).into(binding.imageViewDesayuno)
        binding.imageViewDesayuno.setOnClickListener {
            changeFragment(ListadoPlatillosFragment.newInstance(platilloList))
        }
    }

    private fun loadLocalData(inFile: String): String {
        var contenido = ""
        try {
            val stream = requireContext().assets.open(inFile)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            contenido = String(buffer)
        } catch (e: IOException) {
            Toast.makeText(requireContext(), "Error de Lectura", Toast.LENGTH_LONG).show()
        }
        return contenido
    }

    private fun changeFragment(fragment: Fragment) {
        Toast.makeText(requireContext(), "Cambio", Toast.LENGTH_LONG).show()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
    }

    companion object {
        fun newInstance() = DesayunosFragment()
    }
}