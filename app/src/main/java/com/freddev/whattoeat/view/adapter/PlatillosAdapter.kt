package com.freddev.whattoeat.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.freddev.whattoeat.R
import com.freddev.whattoeat.model.Platillo

class PlatillosAdapter(private val platillosList: ArrayList<Platillo>) :
    RecyclerView.Adapter<PlatillosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatillosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlatillosViewHolder(layoutInflater.inflate(R.layout.item_platillo, parent, false))
    }

    override fun onBindViewHolder(holder: PlatillosViewHolder, position: Int) {
        val item = platillosList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = platillosList.size
}