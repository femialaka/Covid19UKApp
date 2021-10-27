package com.kiniun.covid.uk.app.views.display

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.data.source.repositories.UKCovidDataRepository
import com.kiniun.covid.uk.app.models.CovidDataType
import com.kiniun.covid.uk.app.utils.AppDateUtil

class DisplayViewModel(private val repository: UKCovidDataRepository) : ViewModel() {

    lateinit var ukData: LiveData<List<CovidRecordEntity>>

    private var _countryCode = 0

    var currentDataType = CovidDataType.NEWCASSES
    var currentDisplayText: CharSequence = ""

    fun setCountryCode(countryCode: Int) {
        _countryCode = countryCode
        ukData = repository.getAll(_countryCode)
    }

    private val _countries = listOf<String>("UK ", "England ", "Scotland ", "Wales ", "Northern Ireland ")

    fun resetDisplayText(dataType: CovidDataType): CharSequence {
        Log.i("MSG", "DisplayViewModel@resetDisplayText $_countryCode")
        when (dataType) {
            CovidDataType.NEWCASSES -> return "${_countries.get(_countryCode)} \n ${ukData.value?.get(0)?.newCases} ${CovidDataType.NEWCASSES.dataType}\n ${AppDateUtil.getDateForYesterday()}"
            CovidDataType.DEATH -> return "${_countries.get(_countryCode)} \n ${ukData.value?.get(0)?.newDeaths} ${CovidDataType.DEATH.dataType} \n ${AppDateUtil.getDateForYesterday()}"
            CovidDataType.ADMISSIONS -> return "${_countries.get(_countryCode)} \n (last week) \n ${ukData.value?.get(0)?.newAdmissions} ${CovidDataType.ADMISSIONS.dataType}"
        }
    }

    val colorMap: Map<String, Int>

    get() = mapOf<String, Int>( CovidDataType.NEWCASSES.dataType to Color.parseColor("#4CAF50").toInt(),
            CovidDataType.ADMISSIONS.dataType to Color.parseColor("#FF9800").toInt(),
            CovidDataType.DEATH.dataType to Color.parseColor("#FF5722").toInt())

    fun getCountry(): String {
        return _countries[_countryCode]
    }
}

class DisplayViewModelFactory(private val repository: UKCovidDataRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisplayViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DisplayViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}