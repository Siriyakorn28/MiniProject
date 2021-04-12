package com.example.project

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dataperiod.*
import kotlinx.android.synthetic.main.activity_dataperiod.btnlogout
import kotlinx.android.synthetic.main.activity_dataperiod.btnreset
import java.text.SimpleDateFormat
import java.util.*

class Dataperiod : AppCompatActivity() {

    var period : FirebaseAuth? = null

    var btndate: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dataperiod)

        val text01 = Toast.makeText(applicationContext, "Please select a date.", Toast.LENGTH_LONG)
        val text02 = Toast.makeText(applicationContext, "Delete complete", Toast.LENGTH_LONG)

        period = FirebaseAuth.getInstance()

        btncal.setOnClickListener() {

            if (this.date01.text.toString() == "" ) {
                text01.show()
            }else{
                if (cal.get(Calendar.DATE) == 1 && cal.get(Calendar.MONTH) == 0){
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DATE) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 1) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 2
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 2) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 3) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH)
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 4) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 5) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH)
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 6) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 7) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 8) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH)
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 9) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 10) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH)
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.MONTH) == 11) {
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 1
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 30
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.MONTH) == 0 || cal.get(Calendar.MONTH) == 2 || cal.get(Calendar.MONTH) == 4 || cal.get(Calendar.MONTH) == 6 || cal.get(Calendar.MONTH) == 7 ||
                        cal.get(Calendar.MONTH) == 9){
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH) - 1
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.MONTH) == 3 || cal.get(Calendar.MONTH) == 5 || cal.get(Calendar.MONTH) == 8 || cal.get(Calendar.MONTH) == 10){
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH)
                    date05.setText("$b/$c/$a")
                }else if (cal.get(Calendar.MONTH) == 1){
                    var a = cal.get(Calendar.YEAR)
                    var b = cal.get(Calendar.MONTH) + 2
                    var c = cal.get(Calendar.DAY_OF_MONTH) + 2
                    date05.setText("$b/$c/$a")
                }else{
                    var a = cal.get(Calendar.YEAR) + 1
                    var b = cal.get(Calendar.MONTH) - 10
                    var c = cal.get(Calendar.DAY_OF_MONTH) - 1
                    date05.setText("$b/$c/$a")
                }
            }
        }
        btnreset.setOnClickListener() {
            date01.setText(null)
            date05.setText(null)
            text02.show()
        }
        btnlogout.setOnClickListener{
            startActivity(Intent(this, Logout::class.java))
        }
        textview_date = this.date01
        btndate = this.chooseday
        textview_date!!.text = "--/--/----"

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        btndate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@Dataperiod,dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }
}