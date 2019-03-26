package com.lucasmbraz.mcu

import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.setPositionBias(viewId: Int, vertical: Float = 0f, horizontal: Float = 0f) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    constraintSet.setVerticalBias(viewId, vertical)
    constraintSet.setHorizontalBias(viewId, horizontal)
    constraintSet.applyTo(this)
}

/**
 * Converts the given int in DPs to PXs
 */
val Int.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density
