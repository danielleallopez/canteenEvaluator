package com.dleal.canteenevaluator.ui.studentCreation

import com.dleal.canteenevaluator.data.dto.StudentData
import com.dleal.canteenevaluator.ui.base.BaseViewModel
import com.dleal.canteenevaluator.usecases.StudentUseCase
import javax.inject.Inject

class CreateStudentViewModel @Inject constructor(
    private val studentUseCase: StudentUseCase
): BaseViewModel() {

    private fun getStudentList() = localDataSource.getStudentList()

    fun createStudent(student: StudentData) = localDataSource.createStudent(student)

    fun updateStudent(student: StudentData) = localDataSource.updateStudent(student)

    fun deleteStudent(studentId: Long) = localDataSource.deleteStudent(studentId)
}