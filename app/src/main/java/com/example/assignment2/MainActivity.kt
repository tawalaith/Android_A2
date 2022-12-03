package com.example.assignment2

import AirplaneDialogFragment
import CarDialogFragment
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)

        var data = arrayOf("Select Vehicle", "Car", "Airplane");

        val CarDialogFragment = CarDialogFragment();
        val AirplaneDialogFragment = AirplaneDialogFragment();

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data );
        var currentSelected: String = "";

        spinner.setSelection(0, false);
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                currentSelected = data.get(p2);
                if (currentSelected == "Car")
                {
                    CarDialogFragment.show(supportFragmentManager, "H");
                    spinner.setSelection(0, false);
                }
                else if(currentSelected == "Airplane")
                {
                    AirplaneDialogFragment.show(supportFragmentManager, "H");
                    spinner.setSelection(0, false);
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater;
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title.toString().contains("Dark"))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        return true;
    }

    fun changeImageTo(imageID: Int) {
        val img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(imageID)
    }

}