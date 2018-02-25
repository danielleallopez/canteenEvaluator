package com.dleal.canteen.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dleal.canteen.ui.mainScreen.StudentListViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
/**
 * Created by Daniel Leal on 25/2/18.
 */
class ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(StudentListViewModel::class.java) -> StudentListViewModel()
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T
}