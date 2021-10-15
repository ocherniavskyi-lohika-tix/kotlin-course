plugins {
    kotlin("jvm") version "1.5.31"
    java
}

group = "org.lohika"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
    testImplementation("io.cucumber:cucumber-java:6.11.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:6.11.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.testng:testng:7.4.0")
    testImplementation("io.rest-assured:rest-assured:4.4.0")
    testImplementation("io.kotest:kotest-runner-junit5:5.0.0.M2")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")

}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

task("cucumberCli") {
    dependsOn("testClasses")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
            // Change glue for your project package where the step definitions are.
            // And where the feature files are.
            args = listOf("--plugin", "pretty", "--glue", "com.lohika", "src/test/resources")
        }
    }
}

tasks.register<Test>("cucumber") {
    useJUnitPlatform()
    System.setProperty("cucumber.junit-platform.naming-strategy", "long")
}

tasks.register<Test>("junit") {
    useJUnitPlatform {
        System.getProperty("includeTags")?.let {
            includeTags(it)
        }
    }
}

tasks.register<Test>("kotest") {
    useJUnitPlatform {
        System.getProperty("includeTags")?.let {
            includeTags(it)
        }
    }
}

tasks.register<Test>("testng") {
    useTestNG {
        System.getProperty("includeGroups")?.let {
            includeGroups(it)
        }
    }

    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}