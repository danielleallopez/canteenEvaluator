package com.dleal.canteenevaluator.di

import com.dleal.canteenevaluator.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Daniel Leal on 2019-06-22.
 */
val mainModule = module {
    //ViewModel
    viewModel { MainViewModel() }
}