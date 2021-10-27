package com.kiniun.covid.uk.app.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.kiniun.covid.uk.app.data.source.local.UKCovidAppDb
import com.kiniun.covid.uk.app.data.source.local.UKCovidDao
import com.kiniun.covid.uk.app.data.source.repositories.UKCovidDataRepository
import com.kiniun.covid.uk.app.util.getOrAwaitValue
import com.kiniun.covid.uk.app.utils.CovidTestDataUtil
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryTest {

    private lateinit var ukCovidDao: UKCovidDao
    private lateinit var db: UKCovidAppDb
    private lateinit var repository: UKCovidDataRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, UKCovidAppDb::class.java)
            .allowMainThreadQueries()
            .build()

        ukCovidDao = db.ukCovidDao()
        repository = UKCovidDataRepository(ukCovidDao)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun databaseInitializationNotNull() {
        TestCase.assertNotNull(ukCovidDao)
    }

    @Test
    fun test_repository_Insertion() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        repository.insert(covidDataList)
        val numberOfRecords = covidDataList.size
        val actuaNumberOfRecords = repository.getAll(0).getOrAwaitValue().size
        TestCase.assertEquals(numberOfRecords, actuaNumberOfRecords)
    }

    @Test
    fun test_repository_get_all_data() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        repository.insert(covidDataList)

        val actuaRecords = repository.getAll(0).getOrAwaitValue()
        MatcherAssert.assertThat(actuaRecords.containsAll(covidDataList), Matchers.`is`(true))
    }

    @Test
    fun test_repository_delete_all_data() = runBlocking {
        val covidDataList = CovidTestDataUtil.covidRecordEntityDataGenerator()
        repository.insert(covidDataList)

        repository.deleteAll()
        val actualNumberOfRecords = repository.getAll(0).getOrAwaitValue().size
        MatcherAssert.assertThat(actualNumberOfRecords, Matchers.`is`(0))
    }
}