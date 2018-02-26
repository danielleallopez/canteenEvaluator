package com.dleal.canteen.domain

import android.support.annotation.StringRes
import java.util.Date

/**
 * Created by Daniel Leal on 26/2/18.
 */
typealias StudentGroup = List<Student>

data class Student(
        val name: String,
        val surname: String,
        val birthday: Date
)