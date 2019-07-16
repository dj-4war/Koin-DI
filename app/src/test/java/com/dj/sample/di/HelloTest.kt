package com.dj.sample.di

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dj.sample.di.modules.helloModules
import com.dj.sample.di.repositories.HelloRepoImpl
import com.dj.sample.di.viewmodel.HelloViewModel
import org.junit.*
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject

/**
 * HelloKodin test to test VM  values
 */
class HelloTest : AutoCloseKoinTest(){

    val model by inject<HelloViewModel>()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before(){
        startKoin {
            modules(helloModules)
        }
    }

    @Test
    fun canSayHello() {
        val helloValue = model.sayHelloToKodin().value
        Assert.assertEquals("Hello Koin",helloValue)
    }
}
