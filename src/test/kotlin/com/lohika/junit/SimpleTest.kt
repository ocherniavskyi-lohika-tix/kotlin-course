package com.lohika.junit

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS

class SimpleTest {

    @Test
    fun `first test`() {
        assert(1 + 1 == 2)
    }

    @Test
    @DisplayName("😱")
    fun `smile test`() {
        println("this is smiling test")

    }

    @Test
    @EnabledOnOs(OS.LINUX, OS.MAC)
    fun onLinuxOrMac() {
        println("This is definitely not a windows pc")
    }
}