package com.intprog32.listviewtuondawhahasige

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intprog32.listviewtuondawhahasige.Data.EmployeesData
import com.intprog32.listviewtuondawhahasige.helper.RecyclerViewAdapter

class RecyclerViewActivity : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_recycler_views)

        val simpleButton = findViewById<Button>(R.id.simple_list_view_button)
        val customButton = findViewById<Button>(R.id.custom_list_view_button)

        val employeeList = listOf(
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey),
            EmployeesData("23228174", "Jhonrel", "Ardiente", R.drawable.monkey)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.employee_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(employeeList)

        simpleButton.setOnClickListener {
            Toast.makeText(this, "opening simple list view", Toast.LENGTH_SHORT).show()

            startActivity(
                Intent(this, SimpleListViewDashboard::class.java)
            )
        }

        customButton.setOnClickListener {
            Toast.makeText(this, "opening custom list view", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, CustomListView::class.java))
        }
    }
}