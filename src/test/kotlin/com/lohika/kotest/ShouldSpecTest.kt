package com.lohika.kotest

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength

class ShouldSpecTest : ShouldSpec({
    should("return the length of the string") {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }

    xshould("return the length of the string 2") {
        "sammys" shouldHaveLength 5
        "".length shouldBe 0
    }
})