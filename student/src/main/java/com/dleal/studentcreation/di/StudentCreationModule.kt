package com.dleal.studentcreation.di

import com.dleal.data.repositories.Local
import com.dleal.data.repositories.StudentRepository
import com.dleal.studentcreation.ui.studentCreation.CreateStudentViewModel
import com.dleal.studentcreation.usecase.StudentUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Daniel Leal on 2019-06-17.
 */
val studentCreationModule = module {
    //Data source
    single { Local() }

    //Repository
    single { StudentRepository(get()) }

    //UseCase
    single { StudentUseCase(get()) }

    //ViewModel
    viewModel { CreateStudentViewModel(get(), get()) }
}