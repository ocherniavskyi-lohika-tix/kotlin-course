package com.lohika.junit.hooks

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class HooksExample {

    companion object {

        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            println("Before all")
        }

        @JvmStatic
        @AfterAll
        fun afterAll() {
            println("After all")
        }
    }

    @BeforeEach
    fun beforeEachHook() {
        println("this is before each")
    }

    @AfterEach
    fun afterEachHook() {
        println("this is after each")
    }


    @Test
    fun test() {
        println("old boring test")
    }

    @Test
    fun test2() {
        println("no, this test more boring")
    }

}