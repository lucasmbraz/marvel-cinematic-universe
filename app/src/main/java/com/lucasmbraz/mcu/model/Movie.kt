package com.lucasmbraz.mcu.model

import androidx.annotation.DrawableRes

data class Movie(
    val id: String,
    val title: String,
    val shortTitle: String,
    val length: String,
    val titlePositionBias: PositionBias,
    @DrawableRes val poster: Int,
    @DrawableRes val backdrop: Int
)

data class PositionBias(val vertical: Float = 0f, val horizontal: Float = 0f)