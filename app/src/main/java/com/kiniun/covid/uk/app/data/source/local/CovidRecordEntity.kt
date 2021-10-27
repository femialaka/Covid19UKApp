package com.kiniun.covid.uk.app.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "covid_table")
data class CovidRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val date: Date?,
    val newAdmissions: Long =0,
    val newCases: Long=0,
    val newDeaths: Long=0,
    val countryCode: Int=0)