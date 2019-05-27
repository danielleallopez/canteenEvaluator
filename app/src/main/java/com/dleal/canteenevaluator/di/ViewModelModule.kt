package com.dleal.canteenevaluator.di

import androidx.lifecycle.ViewModel
import com.dleal.core.di.ViewModelKey
import com.dleal.studentcreation.ui.studentCreation.CreateStudentViewModel
import com.dleal.studentcreation.ui.studentlist.StudentListViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(CreateStudentViewModel::class)
    abstract fun bindCreateStudentViewModel(createStudentViewModel: CreateStudentViewModel): ViewModel
}