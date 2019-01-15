package com.dleal.canteenevaluator.di

import com.dleal.canteenevaluator.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}