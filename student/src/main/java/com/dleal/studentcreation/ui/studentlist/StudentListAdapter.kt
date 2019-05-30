package com.dleal.studentcreation.ui.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dleal.studentcreation.R
import com.dleal.studentcreation.domain.Student
import com.dleal.studentcreation.domain.StudentGroup
import kotlinx.android.synthetic.main.item_student.view.*

class StudentListAdapter : RecyclerView.Adapter<StudentViewHolder>() {

    private var studentList: StudentGroup = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    fun updateStudentList(studentList: StudentGroup) {
        this.studentList = studentList
    }

}

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(student: Student) {
        itemView.apply {
            val fullName = "${student.name} ${student.surname}"
            txt_name.text = fullName
        }
    }
}