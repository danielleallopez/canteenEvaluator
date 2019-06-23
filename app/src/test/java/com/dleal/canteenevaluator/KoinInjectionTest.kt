package com.dleal.canteenevaluator

import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

/**
 * Created by Daniel Leal on 2019-06-17.
 */
class KoinInjectionTest : KoinTest {

    @Test
    fun verifyDependencies() {
        koinApplication { modules(appModules) }.checkModules()
    }
}