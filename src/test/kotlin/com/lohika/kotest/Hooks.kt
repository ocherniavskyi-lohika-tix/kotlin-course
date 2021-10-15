package com.lohika.kotest

import io.kotest.core.spec.style.FunSpec

class Hooks : FunSpec({

    beforeSpec {
        println("Before spec [$it]")
    }

    beforeEach {
        println("Before each [$it]")
    }

    test("sample test 1") {
        println("test 1")
    }

    test("sample test 2") {
        println("test 1")
    }

    afterEach {
        println("After each [$it]")
    }

    afterSpec {
        println("After spec [$it]")
    }
})