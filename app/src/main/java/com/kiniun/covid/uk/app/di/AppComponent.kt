package com.kiniun.covid.uk.app.di

import android.app.Application
import com.kiniun.covid.uk.app.data.source.local.UKCovidAppDb
import com.kiniun.covid.uk.app.data.source.local.UKCovidDao
import com.kiniun.covid.uk.app.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
    fun ukCovidDao() : UKCovidDao
    fun covidAppDatabase(): UKCovidAppDb
    fun application(): Application
}