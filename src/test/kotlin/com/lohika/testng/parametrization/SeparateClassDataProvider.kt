package com.lohika.testng.parametrization

import org.testng.annotations.DataProvider
import org.testng.annotations.Test


class StaticProvider {
    @DataProvider(name = "create")
    fun createData(): Array<Array<Any>> {
        return arrayOf(arrayOf(1, "foo"), arrayOf(2, "boo"), arrayOf(3, "kek"))
    }
}

class MyTest {
    @Test(dataProvider = "create", dataProviderClass = StaticProvider::class)
    fun test(first: Int?, second: String) {
        println("This is first parameter: [$first] and this is second: [$second]")
    }
}
