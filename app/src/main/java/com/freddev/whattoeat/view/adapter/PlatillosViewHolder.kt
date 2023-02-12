package com.freddev.whattoeat.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.freddev.whattoeat.databinding.ItemPlatilloBinding
import com.freddev.whattoeat.model.Platillo

class PlatillosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPlatilloBinding.bind(view)

    fun bind(platillo: Platillo) {
        binding.apply {
            itemPlatillo.text = platillo.nombrePlatillo
            itemIngredientes.text = platillo.ingredientes
        }
    }
}