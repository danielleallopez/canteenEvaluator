package com.dleal.canteen.ui.mainScreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dleal.canteen.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
