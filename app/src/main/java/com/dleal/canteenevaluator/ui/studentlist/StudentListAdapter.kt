package com.dleal.canteenevaluator.ui.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dleal.canteen.domain.Student
import com.dleal.canteen.domain.StudentGroup
import com.dleal.canteenevaluator.R
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
            txt_name.text = "${student.name} ${student.surname}"
        }
    }
}