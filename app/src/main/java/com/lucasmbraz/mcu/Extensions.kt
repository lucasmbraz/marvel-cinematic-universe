package com.lucasmbraz.mcu

import android.app.Activity
import androidx.fragment.app.Fragment

val Activity.app: App
    get() = application as App

val Fragment.app: App?
    get() = activity?.app