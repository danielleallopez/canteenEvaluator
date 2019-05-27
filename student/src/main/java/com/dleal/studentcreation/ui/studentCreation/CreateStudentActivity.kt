package com.dleal.studentcreation.ui.studentCreation

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.dleal.ui.base.BaseActivity
import com.dleal.studentcreation.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_create_student.*

class CreateStudentActivity : BaseActivity<CreateStudentViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_create_student

    override val clazz: Class<CreateStudentViewModel>
        get() = CreateStudentViewModel::class.java

    private fun observeCreateStudentNavigationEvent() {
        viewModel.createStudentNavigationEvent.observe(this, Observer {
            val bundle = bundleOf(CREATED_STUDENT to it.student)
            TODO("Return result")
        })
    }

    private fun observeErrorMessageEvent() {
        viewModel.errorMessageEvent.observe(this, Observer { messageId: Int ->
            Snackbar.make(coordinatorLayout, messageId, Snackbar.LENGTH_SHORT).show()
        })
    }

    private fun configureCreateStudentButton() {
        btn_create.setOnClickListener {
            val name = editStudentName.editText?.text?.toString()

            val surname = editStudentSurname.editText?.text?.toString()

            viewModel.onCreateStudentClick(name, surname)
        }
    }
}

const val CREATED_STUDENT = "createdStudent"