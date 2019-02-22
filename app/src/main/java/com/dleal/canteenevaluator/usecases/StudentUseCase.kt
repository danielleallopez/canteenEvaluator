package com.dleal.canteenevaluator.usecases

import com.dleal.canteenevaluator.data.dto.StudentData
import com.dleal.canteenevaluator.data.repositories.StudentRepository
import javax.inject.Inject

class StudentUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    fun getStudent() = studentRepository.getStudent()

    fun createStudent(student: StudentData) = studentRepository.createStudent(student)

    fun updateStudent(student: StudentData) = studentRepository.updateStudent(student)

    fun deleteStudent(studentId: Long) = studentRepository.deleteStudent(studentId)
}