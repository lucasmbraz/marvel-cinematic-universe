package com.lucasmbraz.mcu

import android.app.Activity

val Activity.app: App
    get() = application as App