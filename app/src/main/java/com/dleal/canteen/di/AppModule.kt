package com.dleal.canteen.di

import com.dleal.canteen.ui.mainScreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Daniel Leal on 26/2/18.
 */
@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}