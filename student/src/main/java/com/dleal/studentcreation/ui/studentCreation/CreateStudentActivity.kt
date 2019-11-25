package com.dleal.studentcreation.ui.studentCreation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
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
        fun openForResult(callingActivity: Activity) {
            val intent = Intent(callingActivity, CreateStudentActivity::class.java)
            callingActivity.startActivityForResult(intent, REQUEST_CODE_CREATE_STUDENT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureCreateStudentButton()

        observeCreateStudentNavigationEvent()
        observeErrorMessageEvent()
    }

    private fun observeCreateStudentNavigationEvent() {
        viewModel.createStudentNavigationEvent.observe(this, Observer {
            val intent = Intent()
            intent.putExtra(CREATED_STUDENT, it.student)
            setResult(Activity.RESULT_OK, intent)
            finish()
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
const val REQUEST_CODE_CREATE_STUDENT = 1000