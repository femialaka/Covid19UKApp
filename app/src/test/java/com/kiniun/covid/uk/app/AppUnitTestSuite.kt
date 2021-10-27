package com.kiniun.covid.uk.app

import com.kiniun.covid.uk.app.data.source.remote.CovidApiUnitTest
import com.kiniun.covid.uk.app.data.source.repositories.RepositoryTest
import com.kiniun.covid.uk.app.main.MainViewModelTest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainViewModelTest::class,
    RepositoryTest::class,
    CovidApiUnitTest::class
)
class AppUnitTestSuite