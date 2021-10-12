package com.lohika.testng.dependencies

import org.testng.annotations.Test


class DependsOnMethod {

    @Test(groups = ["init"])
    fun firstTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["thirdTest"])
    fun secondTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["firstTest"])
    fun thirdTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["firstTest"])
    fun fourthTest() {
        println("this is integration test")
    }
}

