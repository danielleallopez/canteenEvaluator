package com.dleal.canteenevaluator.mappers

import com.dleal.canteenevaluator.data.dto.StudentData
import com.dleal.canteenevaluator.domain.Student

fun mapStudentToData(student: Student): StudentData =
    with(student) {
        StudentData(
            name = name,
            surname = surname,
            birthday = birthday
        )
    }

fun mapStudentDataToDomain(studentData: StudentData) : Student {
    return with(studentData){
        Student(
            id = id ?: 0,
            name = name,
            surname = surname,
            birthday = birthday
        )
    }
}