package com.sudip.calendarassignment

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var edtone:EditText
    private lateinit var edttwo: EditText
    private lateinit var txtone:TextView
    private lateinit var texttwo: TextView
    private var m:Int=0
    private var mo:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtone=findViewById(R.id.edtone)
        edttwo=findViewById(R.id.edttwo)
        txtone=findViewById(R.id.txtone)
        texttwo=findViewById(R.id.texttwo)

        edtone.setOnClickListener {
            loadCalendar()
        }

        edttwo.setOnClickListener {
            loadDobCalendar()
        }

    }

    private fun loadCalendar(){
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, jmonth, dayOfMonth ->
                val year1=c.get(Calendar.YEAR)
                val cmonth=c.get(Calendar.MONTH)
                edtone.setText("$dayOfMonth/${jmonth+1}/$year")
                if(year1>=year){
                    val y=year1-year
                    if(cmonth>=jmonth){
                        m=cmonth-jmonth
                    }
                    else{
                        m=(cmonth+1)-(jmonth+1)+12

                    }
                    val joining="No. of years worked : ${y} years and ${m} months"
                    txtone.text=joining.toString()
                }else{
                    texttwo.text="are u really from this era"
                }



            },
            year-1,month,day
        )
        datePickerDialog.show()
    }

    private fun loadDobCalendar(){
        val c= Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog= DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, dobmonth, dayOfMonth ->
                edttwo.setText("$dayOfMonth/${dobmonth+1}/$year")
                val year1=c.get(Calendar.YEAR)
                val cmonth=c.get(Calendar.MONTH)

                if(year1>=year){
                    val y=year1-year
                    if(cmonth>=dobmonth){
                        mo=cmonth-dobmonth
                    }
                    else{
                        mo=(cmonth+1)-(dobmonth+1)+12

                    }
                    val Dob="Your age is : ${y} years old ${mo} months"
                    texttwo.text=Dob.toString()
                }else{
                    texttwo.text="are u really from this era"
                }


            },
            year-20,month,day
        )
        datePickerDialog.show()
    }
}
