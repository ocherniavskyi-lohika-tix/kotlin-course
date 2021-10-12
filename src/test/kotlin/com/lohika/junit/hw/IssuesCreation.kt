package com.lohika.junit.hw

import io.restassured.RestAssured.given
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasEntry
import org.hamcrest.Matchers.hasItem
import org.junit.jupiter.api.Test

class IssuesCreation {

    @Test
    fun createIssue() {
        val issue = mapOf(
            "title" to "Issue from test",
            "body" to "some issue content",
//            "assignee" to "ocherniavskyi-lohika-tix"
        )

        given()
            .baseUri("https://api.github.com")
            .auth().preemptive().basic("ocherniavskyi-lohika-tix", token)
            .contentType("application/json")
            .accept("application/vnd.github.v3+json")
            .body(issue)
            .post("repos/ocherniavskyi-lohika-tix/kotlin-course/issues").also {
                it.body.prettyPrint()
            }
            .then()
            .statusCode(201)
    }

    @Test
    fun getListOfIssues() {
        given()
            .baseUri("https://api.github.com")
            .auth().preemptive().basic("ocherniavskyi-lohika-tix", token)
            .contentType("application/json")
            .accept("application/vnd.github.v3+json")
            .get("/repos/ocherniavskyi-lohika-tix/kotlin-course/issues").also {
                it.body.prettyPrint()
            }
            .then()
            .body("$", hasItem(hasEntry("title", "Issue from test")))
            .statusCode(200)
    }

    companion object {
        const val token = "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"
    }
}