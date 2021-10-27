package com.kiniun.covid.uk.app.models

import java.util.*

data class CovidData(
    val data: List<CovidRecord>?,
    val maxPageLimit: Int,
    val length: Int
)

data class CovidRecord(
    val date: Date?,
    val newAdmissions: Long=0,
    val newCases: Long=0,
    val newDeaths: Long=0
)