package com.dleal.canteen.ui.mainScreen

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.dleal.canteen.domain.Student
import com.dleal.canteen.domain.StudentGroup
import com.dleal.canteen.ui.base.BaseViewModel
import java.util.Date

/**
 * Created by Daniel Leal on 26/2/18.
 */
class MainViewModel : BaseViewModel() {

    val studentGroupUiModel: MutableLiveData<StudentListUiModel> = MutableLiveData()

    init {
        studentGroupUiModel.value = StudentListUiModel(true, emptyList())
        val studentList = listOf(
                Student(name = "John", surname = "Doe", birthday = Date()),
                Student(name = "John", surname = "Doe", birthday = Date()),
                Student(name = "John", surname = "Doe", birthday = Date()),
                Student(name = "John", surname = "Doe", birthday = Date()),
                Student(name = "John", surname = "Doe", birthday = Date())
        )
        Handler().postDelayed(
                { studentGroupUiModel.value = StudentListUiModel(false, emptyList()) },
                2000
        )
    }
}

data class StudentListUiModel(
        val showProgress: Boolean,
        val studentList: StudentGroup
)