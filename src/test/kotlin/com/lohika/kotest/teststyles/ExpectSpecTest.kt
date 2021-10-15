package com.lohika.kotest.teststyles

import io.kotest.core.spec.style.ExpectSpec

class ExpectSpecTest : ExpectSpec({
    context("a calculator") {
        expect("simple addition") {
            // test here
        }
        expect("integer overflow") {
            // test here
        }
    }
})