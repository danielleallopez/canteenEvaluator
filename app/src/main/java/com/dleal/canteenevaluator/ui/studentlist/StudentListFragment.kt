package com.dleal.canteenevaluator.ui.studentlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dleal.canteenevaluator.R
import com.dleal.canteenevaluator.ui.base.BaseFragment
import com.dleal.canteenevaluator.utils.hide
import com.dleal.canteenevaluator.utils.show
import kotlinx.android.synthetic.main.student_list_fragment.*

class StudentListFragment : BaseFragment<StudentListViewModel>() {

    override fun getLayoutId(): Int = R.layout.student_list_fragment

    override fun provideViewModel(): StudentListViewModel =
        ViewModelProviders.of(this, viewModelFactory).get(StudentListViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureStudentList()

        observeStudentListEvents()
    }

    private fun observeStudentListEvents() {
        viewModel.studentGroupUiModel.observe(this, Observer { studentListUiModel: StudentListUiModel? ->
            studentListUiModel?.let {
                with(it) {
                    when {
                        showProgress -> progress_student_list.show()
                        studentList.isEmpty() -> {
                            progress_student_list.hide()
                            txt_student_list_empty_case.show()
                        }
                        else -> {
                            progress_student_list.hide()
                            txt_student_list_empty_case.hide()
                            rv_students.show()
                            (rv_students.adapter as StudentListAdapter).updateStudentList(studentList)
                        }
                    }
                }
            }
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
}