package com.dleal.canteenevaluator.ui.studentCreation

import com.dleal.canteenevaluator.R
import com.dleal.canteenevaluator.ui.base.BaseFragment

class CreateStudentFragment : BaseFragment<CreateStudentViewModel>() {

    override fun getLayoutId(): Int = R.layout.create_student_fragment

    override val clazz: Class<CreateStudentViewModel>
        get() = CreateStudentViewModel::class.java
}
