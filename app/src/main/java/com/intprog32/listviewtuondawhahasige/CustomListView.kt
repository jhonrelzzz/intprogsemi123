package com.intprog32.listviewtuondawhahasige

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.intprog32.listviewtuondawhahasige.Data.StudentsData
import com.intprog32.listviewtuondawhahasige.helper.CustomListViewAdapter

class CustomListView : Activity() {

    lateinit var studentList: MutableList<StudentsData>
    lateinit var adapter: CustomListViewAdapter
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        button = findViewById(R.id.simple_list_view_button)
        val recyclerButton = findViewById<Button>(R.id.recycler_view_button)

        val listView = findViewById<ListView>(R.id.listView)
        val addButton = findViewById<Button>(R.id.add_button)
        val delButton = findViewById<Button>(R.id.remove_button)

        studentList = mutableListOf(
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey),
            StudentsData("Jhonrel", "Ardiente", R.drawable.monkey)
        )

        adapter = CustomListViewAdapter(
            this,
            studentList,
            onClick = {student ->
                Toast.makeText(this, "${student.firstName} was clicked!", Toast.LENGTH_SHORT).show()
            },
            onLongClick = {student ->
                val position = studentList.indexOf(student)
                if(position != -1){
                    showRemoveDialog(position)
                }
            }
         )

        listView.adapter = adapter

        addButton.setOnClickListener {
            /*studentList.add(
                StudentsData("Jasmine", "Campana", R.drawable.monkey)
            )
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "A student is added",
                Toast.LENGTH_SHORT).show()*/

            showAddDialog()
        }

        delButton.setOnClickListener {
            val removedItem = studentList.removeAt(studentList.size.minus(1))

            adapter.notifyDataSetChanged()

            Toast.makeText(this, "${removedItem.firstName} ${removedItem.lastName} was removed",
                Toast.LENGTH_SHORT).show()
        }

        listView.setOnItemLongClickListener{ _, _, position, _ ->
            showRemoveDialog(position)
            true
        }

        button.setOnClickListener {
            Toast.makeText(this, "opening simple list view",
                Toast.LENGTH_SHORT).show()

            startActivity(
                Intent(this, SimpleListViewDashboard::class.java)
            )
        }

        recyclerButton.setOnClickListener {
            Toast.makeText(this, "opening recycler view",
                Toast.LENGTH_SHORT).show()

            startActivity(
                Intent(this, RecyclerViewActivity::class.java)
            )
        }
    }



    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add a Student")

        val inflater = layoutInflater
        val dialogView = inflater.inflate(
            R.layout.dialog_add_student,
            null
        )
        builder.setView(dialogView)

        val dlgFirstname = dialogView.findViewById<EditText>(R.id.dialog_firstname_editText)
        val dlgLastname = dialogView.findViewById<EditText>(R.id.dialog_lastname_editText)

        builder.setPositiveButton("Add"){ _, _ ->
            val firstname = dlgFirstname.text.toString()
            val lastname = dlgLastname.text.toString()

            if (!firstname.isEmpty() && !lastname.isEmpty()){
                studentList.add(
                StudentsData("Jasmine", "Campana", R.drawable.monkey)
                )

                adapter.notifyDataSetChanged()

                Toast.makeText(this, "A student is added",
                    Toast.LENGTH_SHORT).show()

            } else if (firstname.isEmpty() || lastname.isEmpty()){
                Toast.makeText(this,
                    "please fill the fields before adding",
                    Toast.LENGTH_SHORT).show()

                return@setPositiveButton
            }
        }

        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun showRemoveDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Student")
        builder.setMessage("Are you sure you want to remove ${studentList[position].firstName}?")

        /*val inflater = layoutInflater
        val dialogView = inflater.inflate(
            R.layout.dialog_delete_student,
            null
        )
        builder.setView(dialogView)*/

        builder.setPositiveButton("Remove"){ _, _ ->
            val removedItem = studentList.removeAt(position)

            adapter.notifyDataSetChanged()

            Toast.makeText(this, "${removedItem.firstName} ${removedItem.lastName} was removed",
                Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}