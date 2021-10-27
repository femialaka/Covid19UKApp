package com.kiniun.covid.uk.app.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.data.source.repositories.CovidDataRepository
import com.kiniun.covid.uk.app.data.source.repositories.UKCovidDataRepository
import com.kiniun.covid.uk.app.models.CovidData
import com.kiniun.covid.uk.app.models.CovidDataType
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: UKCovidDataRepository) : ViewModel() {

    private val _dbInitialized = MutableLiveData<Boolean>()
    val dbInitialized: LiveData<Boolean>
        get() = _dbInitialized

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    private val _data = MutableLiveData<CovidData>()
    val data: LiveData<CovidData>
        get() = _data

    private val disposables = CompositeDisposable()

    fun loadData(apiList: List<Single<CovidData>>) {

        if(dbInitialized.value == true)
            return

        clearDb()
        for (countryCode in apiList.indices) {
            initApp(apiList.get(countryCode), countryCode,true)
        }
    }

    fun initApp(apiClient: Single<CovidData>, countryCode: Int,  cacheData: Boolean) {

        if(dbInitialized.value == true)
            return

        _loading.value = true
        _error.value = false

        var covidData = CovidData(emptyList(), 0, 0)

        apiClient
            .subscribeBy(
                onSuccess = { it ->
                    viewModelScope.launch(Dispatchers.Main) {
                        _loading.value = false
                        _error.value = false
                        _data.value = it
                        if(cacheData)
                            initializeDB(it, countryCode)
                    }
                },
                onError = {
                    _loading.value = false
                    _error.value = true
                }
            )
    }

    fun loadData() {
        _loading.value = true
        _error.value = false
    }

    fun getCovidData(countryCode: Int): LiveData<List<CovidRecordEntity>> {
        return repository.getAll(countryCode)
    }

    private fun initializeDB(covidDataPayload: CovidData, countryCode: Int) {
        val list = CovidRecordListToEntityList(covidDataPayload, countryCode)
        viewModelScope.launch {
            repository.insert(list)
        }

        Log.i("MSG", "initializeDB:  $countryCode")
       //========== _dbInitialized.value = true
    }

    private fun CovidRecordListToEntityList(covidDataPayload: CovidData, countryCode: Int): List<CovidRecordEntity> {
        val list = mutableListOf<CovidRecordEntity>()

        covidDataPayload.data.let { covidRecordList ->
            if (covidRecordList != null) {
                Log.i("MSG", "CovidRecordListToEntityList:  $countryCode")
                viewModelScope.launch {
                    covidRecordList.forEach {
                        list.add(
                            CovidRecordEntity(
                                null,
                                it.date,
                                it.newAdmissions,
                                it.newCases,
                                it.newDeaths,
                                countryCode
                            )
                        )
                    }
                }
            }
        }
        return list
    }

    private fun clearDb() {
        viewModelScope.launch {
            repository.deleteAll()
        }
        Log.i("MSG", "clearDb()...")
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}

class MainViewModelFactory(private val repository: UKCovidDataRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}