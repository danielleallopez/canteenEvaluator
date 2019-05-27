package com.dleal.canteenevaluator.ui.main

import com.dleal.canteenevaluator.R
import com.dleal.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getLayoutId(): Int = R.layout.main_activity

    override val clazz: Class<MainViewModel>
        get() = MainViewModel::class.java
}
