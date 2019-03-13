package com.dleal.canteenevaluator.ui.studentCreation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.dleal.canteenevaluator.R
import com.dleal.canteenevaluator.ui.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.create_student_fragment.*

class CreateStudentFragment : BaseFragment<CreateStudentViewModel>() {

    override fun getLayoutId(): Int = R.layout.create_student_fragment

    override val clazz: Class<CreateStudentViewModel>
        get() = CreateStudentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeCreateStudentNavigationEvent()
        observeErrorMessageEvent()
        configureCreateStudentButton()
    }

    private fun observeCreateStudentNavigationEvent() {
        viewModel.createStudentNavigationEvent.observe(this, Observer {
            val bundle = bundleOf(CREATED_STUDENT to it.student)
            findNavController()
                .navigate(R.id.backToStudentList, bundle, NavOptionsBuilder)
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