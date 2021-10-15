package com.lohika.kotest

import io.kotest.core.NamedTag
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import kotlin.math.max
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

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

class NestedTestExamples : DescribeSpec({

    describe("an outer test") {

        it("an inner test") {
            1 + 2 shouldBe 3
        }

        it("an inner test too!") {
            3 + 4 shouldBe 7
        }

        assert(false)
    }

})

val regression = NamedTag("regression")
val ui = NamedTag("ui")

