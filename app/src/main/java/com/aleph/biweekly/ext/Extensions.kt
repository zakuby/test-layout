package com.aleph.biweekly.ext

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*


fun Int.secondsToString(
    dateFormat: DateFormat = DateFormat.FullDateWithMonthName
): String = this.toLong().secondsToString(dateFormat)

fun Long.secondsToString(
    dateFormat: DateFormat = DateFormat.FullDateWithMonthName
): String = try {
        val format = SimpleDateFormat(dateFormat.format, Locale.getDefault())
        format.format(this * 1000L)
    } catch (e: Exception) {
        this.toString()
    }

fun Int.dp(context: Context): Int  = this * context.resources.displayMetrics.density.toInt()


enum class DateFormat(val format: String) {
    FullDateWithNumber("dd/MM/yyyy"),
    FullDateWithNumberAndSpace("dd MM yyyy"),
    HalfDateWithMonthName("d MMMM yyyy"),
    FullDateWithMonthName("dd MMMM yyyy"),
    MonthWithYear("MMMM yyyy"),
    Month("MMMM"),
    Date("dd"),
    ISO8601("yyyy-MM-dd"),
    ISO8601YearMonth("yyyy-MM"),
    YearWithMonth("yyyy-MM"),
    DateWithMonth3("dd MMM"),
    FullDateWithMonth3("dd MMM yyyy"),
    UTC("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
}