package com.lohika.testng.parametrization

import org.testng.annotations.Parameters
import org.testng.annotations.Test

class XmlParameters {

    @Parameters("first-name")
    @Test
    fun verifyData1(firstName: String) {
        println("This is parameter: [$firstName]")
    }
}