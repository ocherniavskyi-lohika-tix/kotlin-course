package com.lohika.kotest.parametrization

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import kotlin.math.max

class Parametrization : FunSpec({
    context("Parametrization tests") {
        withData(
            nameFn = { value -> "this is test name : $value" },
            Triple(3, 4, 5),
            Triple(6, 8, 10),
            Triple(8, 15, 17),
            Triple(7, 24, 25)
        ) { (a, b, c) ->
            println("First: $a")
            println("Second: $b")
            println("Third: $c")
        }
    }
})

class Parametrization2 : StringSpec({
    "maximum of two numbers" {
        forAll(
            row(1, 5, 5),
            row(1, 0, 1),
            row(0, 0, 0)
        ) { a, b, max ->
            max(a, b) shouldBe max
        }
    }
})

class Parametrization3 : StringSpec({
    listOf(
        "a", "b", "c"
    ).forEach {
        "iterate value: $it" {
            println("Value is $it")
        }
    }
})