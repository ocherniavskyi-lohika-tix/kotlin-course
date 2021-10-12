package com.lohika.testng

import org.testng.annotations.Test

class SimpleTest {

    @Test
    fun `simple test`() {
        println("simple test")
    }
}

@Test
class ClassLevelAnnotation {

    fun `simple test`() {
        println("simple test")
    }

    fun `simple test 2`() {
        println("simple test 2")
    }
}