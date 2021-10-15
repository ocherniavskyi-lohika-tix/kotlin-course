package com.lohika.kotest.teststyles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecTest : StringSpec({
    "strings.length should return size of string" {
        "hello".length shouldBe 5
    }
})