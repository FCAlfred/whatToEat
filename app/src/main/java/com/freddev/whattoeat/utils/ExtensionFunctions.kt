package com.freddev.whattoeat.utils

import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import java.io.IOException

fun View.setViewGone(status: Boolean) {
    this.visibility = if (status) View.GONE else View.VISIBLE
}

fun View.setViewInvisible(status: Boolean) {
    this.visibility = if (status) View.INVISIBLE else View.VISIBLE
}