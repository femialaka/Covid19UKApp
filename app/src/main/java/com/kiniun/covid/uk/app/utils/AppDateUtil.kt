package com.kiniun.covid.uk.app.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class AppDateUtil {

    companion object {
        fun getSimpleFormatter() : SimpleDateFormat {
            return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        }

        fun getDateForYesterday(): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, -1)

            val yesterday = calendar.time
            return dateToString(yesterday)
        }

        fun dateToString(date: Date?): String {
            return SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(date)
        }
    }

}