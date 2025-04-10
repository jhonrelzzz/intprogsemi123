package com.intprog32.listviewtuondawhahasige.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intprog32.listviewtuondawhahasige.Data.EmployeesData
import com.intprog32.listviewtuondawhahasige.R
import org.w3c.dom.Text

class RecyclerViewAdapter(private val listOfEmployees: List<EmployeesData>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

        class ItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
            val empPhoto = view.findViewById<ImageView>(R.id.employee_profile)
            val empID = view.findViewById<TextView>(R.id.employee_id)
            val firstName = view.findViewById<TextView>(R.id.first_name)
            val lastName = view.findViewById<TextView>(R.id.last_name)
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_recycler_view, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ItemViewHolder, position: Int) {
        val item = listOfEmployees[position]

        holder.empPhoto.setImageResource(item.empProfile)
        holder.empID.setText(item.employeeID)
        holder.firstName.setText(item.empFirstName)
        holder.lastName.setText(item.empLastName)
    }

    override fun getItemCount(): Int = listOfEmployees.size
}