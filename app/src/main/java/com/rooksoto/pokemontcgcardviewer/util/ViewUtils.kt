package com.rooksoto.pokemontcgcardviewer.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun cardImageProgressDrawable(context: Context) =
    CircularProgressDrawable(context).apply {
        strokeWidth = 20f
        centerRadius = 100f
        start()
    }
