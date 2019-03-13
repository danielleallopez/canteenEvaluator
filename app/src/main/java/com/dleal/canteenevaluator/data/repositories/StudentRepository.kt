package com.dleal.canteenevaluator.data.repositories

import com.dleal.canteenevaluator.data.base.local.BaseLocalDataSource
import com.dleal.canteenevaluator.data.dto.StudentData
import javax.inject.Inject

class StudentRepository @Inject constructor(private val localDataSource: Local) {

    fun getStudentList() = localDataSource.getStudentList()

    fun createStudent(student: StudentData) = localDataSource.createStudent(student)

    fun updateStudent(student: StudentData) = localDataSource.updateStudent(student)

    fun deleteStudent(studentId: Long) = localDataSource.deleteStudent(studentId)
}

class Local @Inject constructor() : BaseLocalDataSource() {
    private val translationsDao by lazy { appDatabase.getTranslationsDao() }

    fun getStudentList() = translationsDao.getStudentList()

    fun createStudent(student: StudentData): Long = translationsDao.saveStudentData(student)

    fun updateStudent(student: StudentData)= translationsDao.updateStudentData(student)

    fun deleteStudent(studentId: Long) = translationsDao.deleteStudentById(studentId) == 1
}