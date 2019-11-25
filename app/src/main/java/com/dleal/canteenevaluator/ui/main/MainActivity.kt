package com.dleal.canteenevaluator.ui.main

import android.content.Intent
import com.dleal.canteenevaluator.R
import com.dleal.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.main_activity

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
