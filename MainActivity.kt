package com.example.inputcontrols

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editPhone: EditText
    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var btnAlert: Button
    private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi view
        editPhone = findViewById(R.id.editPhone)
        btnDate = findViewById(R.id.btnDate)
        btnTime = findViewById(R.id.btnTime)
        btnAlert = findViewById(R.id.btnAlert)
        btnToast = findViewById(R.id.btnToast)

        // Date Picker
        btnDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this,
                { _, year, month, day ->
                    Toast.makeText(this, "Tanggal: $day/${month + 1}/$year", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        // Time Picker
        btnTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePicker = TimePickerDialog(this,
                { _, hour, minute ->
                    Toast.makeText(this, "Waktu: $hour:$minute", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePicker.show()
        }

        // Alert Dialog
        btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Peringatan")
                .setMessage("Ini adalah Alert Sederhana.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Toast Message
        btnToast.setOnClickListener {
            val phone = editPhone.text.toString()
            Toast.makeText(this, "Nomor yang dimasukkan: $phone", Toast.LENGTH_SHORT).show()
        }
    }
}