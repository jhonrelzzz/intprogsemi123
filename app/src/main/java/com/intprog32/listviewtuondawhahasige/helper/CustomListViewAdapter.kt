package com.intprog32.listviewtuondawhahasige.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.intprog32.listviewtuondawhahasige.Data.StudentsData
import com.intprog32.listviewtuondawhahasige.R

class CustomListViewAdapter(private val context: Context,
                            private val studentList: List<StudentsData>,
                            private val onClick: (StudentsData) -> Unit,
                            private val onLongClick: (StudentsData) -> Unit
    ): BaseAdapter() {
    override fun getCount(): Int =  studentList.size

    override fun getItem(position: Int): Any = studentList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.student_custom_list_view, parent, false)

        val profile = view.findViewById<ImageView>(R.id.student_pf_customlv)
        val fullName = view.findViewById<TextView>(R.id.student_fullName_tv)

        val student = studentList[position]

        profile.setImageResource(student.photo)
        fullName.setText("${student.firstName} ${student.lastName}")

        view.setOnClickListener{
            onClick(student)
        }

        view.setOnLongClickListener{
            onLongClick(student)
            true
        }

        return view
    }


}