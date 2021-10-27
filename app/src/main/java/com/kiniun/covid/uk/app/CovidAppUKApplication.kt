package com.kiniun.covid.uk.app

import android.app.Application
import com.kiniun.covid.uk.app.data.source.local.UKCovidAppDb
import com.kiniun.covid.uk.app.data.source.repositories.UKCovidDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CovidAppUKApplication : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { UKCovidAppDb.getDatabase(this) } //, applicationScope)
    val repository by lazy { UKCovidDataRepository(database.ukCovidDao()) }
}