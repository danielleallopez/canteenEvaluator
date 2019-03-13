package com.dleal.canteenevaluator.usecases

import com.dleal.canteenevaluator.data.dto.StudentData
import com.dleal.canteenevaluator.data.repositories.StudentRepository
import com.dleal.canteenevaluator.domain.Student
import com.dleal.canteenevaluator.mappers.mapStudentDataToDomain
import io.reactivex.Single
import javax.inject.Inject

class StudentUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    fun getStudentList(): Single<List<Student>> =
        studentRepository.getStudentList()
            .flatMap { studentDataList: List<StudentData> ->
                Single.just(studentDataList.map { mapStudentDataToDomain(it) })
            }

    fun createStudent(student: StudentData) = studentRepository.createStudent(student)

    fun updateStudent(student: StudentData) = studentRepository.updateStudent(student)

    fun deleteStudent(studentId: Long) = studentRepository.deleteStudent(studentId)
}