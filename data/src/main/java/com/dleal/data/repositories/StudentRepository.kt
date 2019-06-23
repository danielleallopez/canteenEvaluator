package com.dleal.data.repositories

import com.dleal.data.base.local.BaseLocalDataSource
import com.dleal.data.dto.StudentData

class StudentRepository(private val localDataSource: Local) {

    fun getStudentList() = localDataSource.getStudentList()

    fun createStudent(student: StudentData) = localDataSource.createStudent(student)

    fun updateStudent(student: StudentData) = localDataSource.updateStudent(student)

    fun deleteStudent(studentId: Long) = localDataSource.deleteStudent(studentId)
}

class Local : BaseLocalDataSource() {
    private val translationsDao by lazy { appDatabase.getTranslationsDao() }

    fun getStudentList() = translationsDao.getStudentList()

    fun createStudent(student: StudentData): Long = translationsDao.saveStudentData(student)

    fun updateStudent(student: StudentData) = translationsDao.updateStudentData(student)

    fun deleteStudent(studentId: Long) = translationsDao.deleteStudentById(studentId) == 1
}