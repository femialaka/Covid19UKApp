package com.kiniun.covid.uk.app.data.source.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [CovidRecordEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UKCovidAppDb : RoomDatabase() {

    abstract fun ukCovidDao(): UKCovidDao

    companion object {

        var ukCovidAppDb: UKCovidAppDb? = null

        @Synchronized
        fun getDatabase(context: Context): UKCovidAppDb {

            if (ukCovidAppDb == null) {
                ukCovidAppDb = Room.databaseBuilder(
                    context,
                    UKCovidAppDb::class.java,
                    "covid_database"
                )
                .build()
            }
            return ukCovidAppDb!!
        }
    }
}