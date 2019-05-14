package com.lucasmbraz.mcu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasmbraz.mcu.di.PageChangerModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var pageChanger: PageChanger

    private val component by lazy {
        app.component.plus(PageChangerModule(supportFragmentManager))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (savedInstanceState == null) {
            pageChanger.showMoviesFragment()
        }
    }
}
