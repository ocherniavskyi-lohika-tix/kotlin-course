package com.lohika.testng.dependencies

import org.testng.annotations.Test


class DependsOnGroups {

    @Test(groups = ["init"])
    fun firstTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["firstTest"])
    fun fourthTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["firstTest"])
    fun fifthTest() {
        println("this is integration test")
    }

    @Test(groups = ["init"])
    fun secondTest() {
        println("this is integration test")
    }

    @Test(dependsOnMethods = ["firstTest"], dependsOnGroups = ["init"])
    fun thirdTest() {
        println("this is integration test")
    }
}

