package com.lohika.junit.tagging

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tag("ui")
class Tags {

    @Tags(Tag("login"), Tag("integration"))
    @Test
    fun `integration test`() {
        println("this is integration test")
    }

    @Tag("login")
//    @Tag("login") //Repeatable annotations will be supported according to the KEEP in Kotlin 1.6.
    @Test
    fun `smoke test`() {
        println("this is smoke test")
    }
}