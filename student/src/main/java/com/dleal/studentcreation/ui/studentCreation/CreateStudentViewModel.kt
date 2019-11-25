package com.dleal.studentcreation.ui.studentCreation

import com.dleal.core.utils.RxTransformer
import com.dleal.core.utils.safeLet
import com.dleal.studentcreation.R
import com.dleal.studentcreation.domain.Student
import com.dleal.studentcreation.mappers.mapStudentToData
import com.dleal.studentcreation.usecase.StudentUseCase
import com.dleal.ui.base.BaseViewModel
import com.dleal.ui.base.SingleLiveEvent
import io.reactivex.Single

class CreateStudentViewModel(
    private val studentUseCase: StudentUseCase,
    override val rxTransformer: RxTransformer
) : BaseViewModel() {

    val createStudentNavigationEvent: SingleLiveEvent<CreateStudentUiModel> = SingleLiveEvent()
    val errorMessageEvent: SingleLiveEvent<Int> = SingleLiveEvent()

    fun onCreateStudentClick(name: String?, surname: String?) {

        if (!isNameValid(name)) return

        if (!isSurnameValid(surname)) return

        safeLet(name, surname) { name, surname ->
            val student = Student(name = name, surname = surname)
            val studentData = mapStudentToData(student)

            addDisposable(
                Single.fromCallable { studentUseCase.createStudent(studentData) }
                    .compose(rxTransformer.applyIoScheduler())
                    .subscribe { studentId: Long ->
                        val updatedStudent = student.copy(id = studentId)
                        createStudentNavigationEvent.value = CreateStudentUiModel(student = updatedStudent)
                    }
            )
        }
    }

    private fun isNameValid(name: String?): Boolean {
        if (name.isNullOrBlank()) {
            errorMessageEvent.value = R.string.create_student_missing_name
            return false
        }
        return true
    }

    private fun isSurnameValid(surname: String?): Boolean {
        if (surname.isNullOrBlank()) {
            errorMessageEvent.value = R.string.create_student_missing_surname
            return false
        }
        return true
    }
}

data class CreateStudentUiModel(
    val student: Student
)