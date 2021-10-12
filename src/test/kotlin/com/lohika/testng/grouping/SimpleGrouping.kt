package com.lohika.testng.grouping

import org.testng.annotations.Test

class SimpleGrouping {

    @Test(groups = ["integration", "regression"])
    fun test() {
        println("this is integration test")
    }

    @Test(groups = ["integration", "regression"])
    fun test1() {
        println("this is integration test")
    }

    @Test(groups = ["integration", "smoke"])
    fun test2() {
        println("this is integration test")
    }
}