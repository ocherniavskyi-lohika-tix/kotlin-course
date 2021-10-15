package com.lohika.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec

class SimpleTest : FunSpec() {

    init {
        test("some test name") {
            assert(false)
        }
    }
}


class SimpleTest1 : StringSpec({
    "some fancy test"{
        assert(false) { "extension func example" }
    }
})