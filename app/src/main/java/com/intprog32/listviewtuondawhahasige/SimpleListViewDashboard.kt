package com.intprog32.listviewtuondawhahasige

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class SimpleListViewDashboard : Activity() {

    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple_list_view_dashboard)

        button = findViewById(R.id.custom_list_view_button)
        val recyclerButton = findViewById<Button>(R.id.recycler_view_button)

        val listView: ListView = findViewById(R.id.listView)

        val itemList = listOf("Jhonrel", "James", "Jaymee", "Jasmine", "Jubelyn",
            "Jhonrel", "James", "Jaymee", "Jasmine", "Jubelyn",
            "Jhonrel", "James", "Jaymee", "Jasmine", "Jubelyn",
            "Jhonrel", "James", "Jaymee", "Jasmine", "Jubelyn")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)

        listView.adapter = adapter

        button.setOnClickListener {
            Toast.makeText(this, "opening custom list view", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, CustomListView::class.java))
        }

        recyclerButton.setOnClickListener {
            Toast.makeText(this, "opening recycler view", Toast.LENGTH_SHORT).show()

            startActivity(
                Intent(this, RecyclerViewActivity::class.java)
            )
        }
    }
}