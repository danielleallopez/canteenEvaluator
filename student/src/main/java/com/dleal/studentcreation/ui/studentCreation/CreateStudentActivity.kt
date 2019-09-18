package com.dleal.studentcreation.ui.studentCreation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.dleal.studentcreation.R
import com.dleal.ui.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_create_student.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateStudentActivity : BaseActivity<CreateStudentViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_create_student

    override val viewModel: CreateStudentViewModel by viewModel()

    companion object {
        fun open(callingActivity: Activity) {
            val intent = Intent(callingActivity, CreateStudentActivity::class.java)
            callingActivity.startActivity(intent)
        }
    }

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