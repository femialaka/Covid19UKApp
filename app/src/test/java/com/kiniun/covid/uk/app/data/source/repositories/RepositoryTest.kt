package com.kiniun.covid.uk.app.data.source.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kiniun.covid.uk.app.util.getOrAwaitValue
import com.kiniun.covid.uk.app.utils.CovidTestDataUtil
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryTest {
    // Run tasks synchronously
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var fakeDataSource: FakeDataSource
    lateinit var fakeDataRepository: FakeRepository

    @Before
    fun setup() {
        fakeDataSource = FakeDataSource(CovidTestDataUtil.covidRecordEntityDataGenerator())
        fakeDataRepository = FakeRepository(fakeDataSource)
    }

    @Test
    fun `get all covid data`() {
        val actual = fakeDataRepository.getAll(0).getOrAwaitValue().size
        assertEquals(40, actual )
    }

    @Test
    fun `insert covid data`() = runBlocking {
        fakeDataRepository.insert(CovidTestDataUtil.covidRecordEntityDataGenerator())
        val actual = fakeDataRepository.getAll(0).getOrAwaitValue().size
        assertEquals(80, actual )
    }

    @Test
    fun `make sure repository contains the correct data after insert`() = runBlocking {
        val generatedData = CovidTestDataUtil.covidRecordEntityDataGenerator()
        fakeDataRepository.insert(CovidTestDataUtil.covidRecordEntityDataGenerator())
        val data = fakeDataRepository.getAll(0).getOrAwaitValue()
        assertEquals(true, data.containsAll(generatedData) )
    }

    @Test
    fun `delete all covid data`() = runBlocking {
        fakeDataRepository.insert(CovidTestDataUtil.covidRecordEntityDataGenerator())
        fakeDataRepository.deleteAll()
        val actual = fakeDataRepository.getAll(0).getOrAwaitValue().size
        assertEquals(0, actual)
    }
}