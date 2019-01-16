package com.dleal.canteenevaluator.di

import com.dleal.canteenevaluator.MainActivity
import com.dleal.canteenevaluator.ui.studentlist.StudentListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindStudentListFragment(): StudentListFragment
}