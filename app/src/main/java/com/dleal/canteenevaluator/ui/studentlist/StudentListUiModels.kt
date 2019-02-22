package com.dleal.canteenevaluator.ui.studentlist

import com.dleal.canteenevaluator.domain.StudentGroup

data class StudentListUiModel(
    val showProgress: Boolean,
    val studentList: StudentGroup = emptyList()
)