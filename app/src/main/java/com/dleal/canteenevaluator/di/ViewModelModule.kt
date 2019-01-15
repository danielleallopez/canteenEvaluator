package com.dleal.canteenevaluator.di

import androidx.lifecycle.ViewModel
import com.dleal.canteenevaluator.ui.studentlist.StudentListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    // Bind each ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(StudentListViewModel::class)
    abstract fun bindStudentListViewModel(studentListViewModel: StudentListViewModel): ViewModel
}