package com.dleal.studentcreation.ui.studentDetail

import com.dleal.studentcreation.ui.studentCreation.CreateStudentViewModel
import com.dleal.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Daniel Leal on 2019-06-24.
 */
class StudentDetailFragment : BaseFragment<CreateStudentViewModel>() {
    override val viewModel: CreateStudentViewModel by viewModel()

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}