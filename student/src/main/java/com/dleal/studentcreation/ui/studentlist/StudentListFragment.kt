package com.dleal.studentcreation.ui.studentlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dleal.core.utils.disable
import com.dleal.core.utils.enable
import com.dleal.core.utils.hide
import com.dleal.core.utils.show
import com.dleal.studentcreation.R
import com.dleal.studentcreation.ui.studentCreation.CreateStudentActivity
import com.dleal.studentcreation.ui.studentCreation.REQUEST_CODE_CREATE_STUDENT
import com.dleal.ui.base.BaseFragment
import kotlinx.android.synthetic.main.student_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudentListFragment : BaseFragment<StudentListViewModel>() {

    override val viewModel: StudentListViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.student_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureStudentList()

        configureStudentCreationButton()

        observeStudentListEvents()
        observeCreateStudentNavigationEvent()

        viewModel.start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CREATE_STUDENT && resultCode == Activity.RESULT_OK) {
            viewModel.onStudentCreated()
        }
    }

    private fun observeStudentListEvents() {
        viewModel.studentGroupUiModel.observe(this,
            Observer { studentListUiModel: StudentListUiModel? ->
                studentListUiModel?.let {
                    with(it) {
                        when {
                            showProgress -> {
                                progress_student_list.show()
                                btn_add_student.disable()
                            }
                            studentList.isEmpty() -> {
                                progress_student_list.hide()
                                txt_student_list_empty_case.show()
                                btn_add_student.enable()
                            }
                            else -> {
                                progress_student_list.hide()
                                txt_student_list_empty_case.hide()
                                rv_students.show()
                                (rv_students.adapter as StudentListAdapter).updateStudentList(
                                    studentList
                                )
                                btn_add_student.enable()
                            }
                        }
                    }
                }
            })
    }

    private fun observeCreateStudentNavigationEvent() {
        viewModel.createStudentNavigationEvent.observe(this, Observer {
            openStudentCreationScreen()
        })
    }

    private fun configureStudentList() {
        val viewManager = LinearLayoutManager(context)
        val studentListAdapter = StudentListAdapter()

        rv_students.apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = studentListAdapter
        }
    }

    private fun configureStudentCreationButton() {
        btn_add_student.setOnClickListener { viewModel.onAddUserClick() }
    }

    private fun openStudentCreationScreen() {
        val intent = Intent(activity, CreateStudentActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_CREATE_STUDENT)
    }
}