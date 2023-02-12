package com.freddev.whattoeat.model

data class PlatilloResponse(
    var categoria: String,
    var portada: String,
    var platillo: ArrayList<Platillo>
)
