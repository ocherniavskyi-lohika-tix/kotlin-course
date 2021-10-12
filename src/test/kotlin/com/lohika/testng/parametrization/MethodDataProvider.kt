package com.lohika.testng.parametrization

import org.testng.annotations.DataProvider
import org.testng.annotations.Test


class MethodDataProvider {

    @DataProvider(name = "test1")
    fun createData1(): Array<Array<Any>> {
        return arrayOf(arrayOf("Cedric", 36), arrayOf("Anne", 37))
    }

    @DataProvider(name = "test2")
    fun createData(): Iterator<Array<*>> {
        val params = arrayOf(arrayOf(1, "1"), arrayOf(2, "2"))
        return params.iterator()
    }


    @Test(dataProvider = "test1")
    fun verifyData1(first: String, second: Int) {
        println("This is first parameter: [$first] and this is second: [$second]")
    }

}