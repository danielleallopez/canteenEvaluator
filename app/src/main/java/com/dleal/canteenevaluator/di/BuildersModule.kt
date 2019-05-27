package com.dleal.canteenevaluator.di

import com.dleal.canteenevaluator.ui.main.MainActivity
import com.dleal.studentcreation.ui.studentCreation.CreateStudentActivity
import com.dleal.studentcreation.ui.studentlist.StudentListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindStudentListFragment(): StudentListFragment

    @ContributesAndroidInjector
    abstract fun bindCreateStudentActivity(): CreateStudentActivity
}