package com.aleph.biweekly.data

import com.aleph.biweekly.ext.secondsToString

data class Profile(
    val name: String,
    val age: Int,
    val job: Job,
    val birthDate: Long
){
    override fun toString(): String = "Detail Profile : \n" +
            "Nama : $name \n " +
            "Umur : $age \n " +
            "Pekerjaan : ${job.toString().replace("_", " ")} \n " +
            "Tanggal Lahir : ${birthDate.secondsToString()}"
}