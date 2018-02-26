package com.dleal.canteen.ui.mainScreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.dleal.canteen.R
import com.dleal.canteen.ui.base.BaseActivity
import com.dleal.canteen.utils.hide
import com.dleal.canteen.utils.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        observeStudentListEvents()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun provideViewModel(): MainViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

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
                        }
                    }
                }
            }
        })
    }
}
