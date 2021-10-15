package com.lohika.kotest.teststyles

import io.kotest.core.spec.style.BehaviorSpec

class BehaviorSpecTest : BehaviorSpec({
    given("a broomstick") {
        and("a witch") {
            `when`("I sit on it") {
                then("I should be able to fly") {
                    // test code
                }
            }
            xWhen("I throw it away") {
                then("it should come back") {
                    // test code
                }
            }
        }
    }
})