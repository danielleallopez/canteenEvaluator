package com.dleal.canteenevaluator.data.dto

import androidx.room.*
import io.reactivex.Single
import java.util.*

@Entity(tableName = TABLE_NAME_STUDENT)
data class StudentData(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val name: String,
    val surname: String,
    val birthday: Date?
)

@Dao
interface StudentDao {
    @Query("SELECT * FROM $TABLE_NAME_STUDENT")
    fun getStudentList(): Single<List<StudentData>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun saveStudentData(student: StudentData): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateStudentData(student: StudentData): Int

    @Query("DELETE FROM $TABLE_NAME_STUDENT WHERE id = :studentId")
    fun deleteStudentById(studentId: Long) : Int
}


private const val TABLE_NAME_STUDENT = "Students"