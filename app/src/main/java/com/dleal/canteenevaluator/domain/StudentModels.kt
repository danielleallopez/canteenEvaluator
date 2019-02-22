package com.dleal.canteen.domain

import java.util.*

typealias StudentGroup = List<Student>

data class Student(
    val id: Long,
    val name: String,
    val surname: String,
    val birthday: Date
)