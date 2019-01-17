package com.dleal.canteenevaluator.ui.studentlist

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.dleal.canteen.domain.Student
import com.dleal.canteen.domain.StudentGroup
import com.dleal.canteenevaluator.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject

class StudentListViewModel @Inject constructor() : BaseViewModel() {

    val studentGroupUiModel: MutableLiveData<StudentListUiModel> = MutableLiveData()

    lateinit var studentList: StudentGroup

    init {
        studentList = listOf(
            Student(name = "John", surname = "Doe", birthday = Date()),
            Student(name = "John", surname = "Doe", birthday = Date()),
            Student(name = "John", surname = "Doe", birthday = Date()),
            Student(name = "John", surname = "Doe", birthday = Date()),
            Student(name = "John", surname = "Doe", birthday = Date())
        )

        studentGroupUiModel.value = StudentListUiModel(showProgress = true)
    }

    fun start() {
        Handler().postDelayed({ studentGroupUiModel.value = StudentListUiModel(false, studentList) }, 2000)
    }

    fun onAddUserClick() {

    }
}
