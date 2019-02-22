package com.dleal.canteenevaluator.ui.studentCreation

import com.dleal.canteenevaluator.R
import com.dleal.canteenevaluator.domain.Student
import com.dleal.canteenevaluator.mappers.mapStudentToData
import com.dleal.canteenevaluator.ui.base.BaseViewModel
import com.dleal.canteenevaluator.ui.base.SingleLiveEvent
import com.dleal.canteenevaluator.usecases.StudentUseCase
import com.dleal.canteenevaluator.utils.RxTransformer
import com.dleal.canteenevaluator.utils.safeLet
import io.reactivex.Single
import javax.inject.Inject

class CreateStudentViewModel @Inject constructor(
    private val studentUseCase: StudentUseCase,
    override val rxTransformer: RxTransformer
) : BaseViewModel() {

    val createStudentNavigationEvent: SingleLiveEvent<CreateStudentUiModel> = SingleLiveEvent()
    val errorMessageEvent: SingleLiveEvent<Int> = SingleLiveEvent()

    fun onCreateStudentClick(name: String?, surname: String?) {

        if (!validateName(name)) return

        if (!validateSurname(surname)) return

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

    private fun validateName(name: String?): Boolean {
        if (name.isNullOrBlank()) {
            errorMessageEvent.value = R.string.create_student_missing_name
            return false
        }
        return true
    }

    private fun validateSurname(surname: String?): Boolean {
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