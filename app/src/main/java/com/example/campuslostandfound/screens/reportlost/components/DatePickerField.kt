package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.app.DatePickerDialog
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun DatePickerField(
    selectedDate:String,
    onDateSelected:(String)->Unit
){
    val context=LocalContext.current
    val calendar= Calendar.getInstance()
    val datePickerDialog=remember {
        DatePickerDialog(
            context,
            {_,year,month,dayOfMonth->
                val selectedCalendar= Calendar.getInstance()
                selectedCalendar.set(year,month,dayOfMonth)

                val formattedDate= SimpleDateFormat(
                    "dd/MM/yyyy",
                    Locale.getDefault()
                ).format(selectedCalendar.time)
            onDateSelected(formattedDate)

            },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    OutlinedTextField(
        value=selectedDate,
        onValueChange = {},
        readOnly = true,
        label={
            Text("Date Lost")
        },
        placeholder = {
            Text("Select Date")
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Select Date"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
        }
    )
}