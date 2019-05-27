package com.dleal.studentcreation.ui.studentlist

import com.dleal.studentcreation.domain.StudentGroup

data class StudentListUiModel(
    val showProgress: Boolean,
    val studentList: StudentGroup = emptyList()
)