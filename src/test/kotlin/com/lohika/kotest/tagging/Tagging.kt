package com.lohika.kotest.tagging

import com.lohika.kotest.regression
import com.lohika.kotest.ui
import io.kotest.core.spec.style.StringSpec
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
class Tagging : StringSpec({
    "should use config".config(
        timeout = Duration.seconds(2),
        invocations = 10,
        threads = 2,
        tags = setOf(regression, ui)
    ) {
        "some fancy test"{
            assert(false) { "extension func example" }
        }
    }
})