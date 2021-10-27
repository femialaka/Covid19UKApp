package com.kiniun.covid.uk.app.di

import android.app.Application
import com.kiniun.covid.uk.app.data.source.local.UKCovidAppDb
import com.kiniun.covid.uk.app.data.source.repositories.UKCovidDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(val application: Application) {

    lateinit var database: UKCovidAppDb

    init {
        database = UKCovidAppDb.getDatabase(application)
    }

    @Singleton
    @Provides
    fun providesDatabase() = database

    @Singleton
    @Provides
    fun providesUKCovidDao() = database.ukCovidDao()

    @Singleton
    @Provides
    fun providesUKCovidDataRepository() = UKCovidDataRepository(providesUKCovidDao())

}
