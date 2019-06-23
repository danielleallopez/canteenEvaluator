package com.dleal.studentcreation.usecase

import com.dleal.data.dto.StudentData
import com.dleal.data.repositories.StudentRepository
import com.dleal.studentcreation.domain.Student
import com.dleal.studentcreation.mappers.mapStudentDataToDomain
import io.reactivex.Single

/**
 * Created by Daniel Leal on 2019-05-25.
 */
class StudentUseCase constructor(
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