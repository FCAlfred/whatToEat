package com.freddev.whattoeat.model

import com.google.gson.annotations.SerializedName

data class Platillo(
    var id: Int,
    @SerializedName("titulo") var nombrePlatillo: String,
    var imagen: String,
    @SerializedName("personas") var noPersonas: Int,
    var ingredientes: String,
    @SerializedName("procedimiento") var pasos: String,
    var video: String
)
