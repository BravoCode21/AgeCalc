package com.example.altminuten

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference to the TextView

        val btnDatePicker = findViewById<TextView>(R.id.btnDatePicker)





        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)

        }
    }

    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { view, selectedyear, selectedmonth, selecteddayofMonth  ->
            android.widget.Toast.makeText(
                this@MainActivity,
                "The chosen year is $selectedyear, the month is ${selectedmonth+1} and " +
                        "selectedday is $selecteddayofMonth", android.widget.Toast.LENGTH_SHORT,



            ).show()
            val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)



            var SelectedDate = "${selecteddayofMonth}/${selectedmonth+1}/${selectedyear}"


            tvSelectedDate.setText(SelectedDate)


            val sdf = SimpleDateFormat("dd/MM/yyyy")

            val theDate = sdf.parse(SelectedDate)

            val selectedDateinMinutes = theDate!!.time/60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDatetoMinutes = currentDate!!.time/60000

            val differenceinMins = currentDatetoMinutes - selectedDateinMinutes

            var tvSelectedinMinutes = findViewById<TextView>(R.id.tvSelectedinMinutes)
            tvSelectedinMinutes.setText(differenceinMins.toString())






        },
            year,
            month,
            day).show()




    }




    }