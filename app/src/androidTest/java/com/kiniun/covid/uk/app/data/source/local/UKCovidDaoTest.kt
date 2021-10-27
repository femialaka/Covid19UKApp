package com.kiniun.covid.uk.app.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.kiniun.covid.uk.app.util.getOrAwaitValue
import com.kiniun.covid.uk.app.utils.CovidTestDataUtil
import junit.framework.TestCase.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class UKCovidDaoTest {

    private lateinit var ukCovidDao: UKCovidDao
    private lateinit var db: UKCovidAppDb

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, UKCovidAppDb::class.java)
            .allowMainThreadQueries()
            .build()
        ukCovidDao = db.ukCovidDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun databaseInitializationNotNull() {
        assertNotNull(ukCovidDao)
    }

    @Test
    fun test_database_Insertion() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        ukCovidDao.insert(covidDataList)
        val numberOfRecords = covidDataList.size
        val actuaNumberOfRecords = ukCovidDao.getAll(0).getOrAwaitValue().size
        assertEquals(numberOfRecords, actuaNumberOfRecords)
    }

    @Test
    fun test_database_get_all_data() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        ukCovidDao.insert(covidDataList)

        val actuaRecords = ukCovidDao.getAll(0).getOrAwaitValue()

        assertThat(actuaRecords.containsAll(covidDataList), `is`(true))
    }

    @Test
    fun test_database_delete_all_data() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        ukCovidDao.insert(covidDataList)

        ukCovidDao.deleteAll()
        val actualNumberOfRecords = ukCovidDao.getAll(0).getOrAwaitValue().size

        assertThat(actualNumberOfRecords, `is`(0))
    }
}