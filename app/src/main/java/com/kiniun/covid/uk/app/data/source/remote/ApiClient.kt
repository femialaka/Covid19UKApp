package com.kiniun.covid.uk.app.data.source.remote

import com.kiniun.covid.uk.app.models.CovidData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiClient {
    @GET("data?filters=areaType=overview&structure={\"date\":\"date\",\"newAdmissions\":\"newAdmissions\",\"newCases\":\"newCasesByPublishDate\", \"newDeaths\": \"newDeaths28DaysByPublishDate\", \"maleCases\":\"maleCases\"}")
    fun getUKCovidData(): Single<CovidData>

    @GET("data?filters=areaName=England;areaType=nation&structure={\"date\":\"date\",\"newAdmissions\":\"newAdmissions\",\"newCases\":\"newCasesByPublishDate\", \"newDeaths\": \"newDeaths28DaysByPublishDate\"}")
    fun getEnglandCovidData(): Single<CovidData>

    @GET("data?filters=areaName=Scotland;areaType=nation&structure={\"date\":\"date\",\"newAdmissions\":\"newAdmissions\",\"newCases\":\"newCasesByPublishDate\", \"newDeaths\": \"newDeaths28DaysByPublishDate\"}")
    fun getScotlandCovidData(): Single<CovidData>

    @GET("data?filters=areaName=Wales;areaType=nation&structure={\"date\":\"date\",\"newAdmissions\":\"newAdmissions\",\"newCases\":\"newCasesByPublishDate\", \"newDeaths\": \"newDeaths28DaysByPublishDate\"}")
    fun getWalesCovidData(): Single<CovidData>

    @GET("data?filters=areaName=Northern Ireland;areaType=nation&structure={\"date\":\"date\",\"newAdmissions\":\"newAdmissions\",\"newCases\":\"newCasesByPublishDate\", \"newDeaths\": \"newDeaths28DaysByPublishDate\"}")
    fun getNICovidData(): Single<CovidData>
}