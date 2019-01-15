package com.dleal.canteenevaluator.ui.studentlist

import androidx.lifecycle.ViewModelProviders
import com.dleal.canteenevaluator.R
import com.dleal.canteenevaluator.ui.base.BaseFragment

class StudentListFragment : BaseFragment<StudentListViewModel>() {

    companion object {
        fun newInstance() = StudentListFragment()
    }

    override fun getLayoutId(): Int = R.layout.student_list_fragment

    override fun provideViewModel(): StudentListViewModel =
        ViewModelProviders.of(this, viewModelFactory).get(StudentListViewModel::class.java)
}
