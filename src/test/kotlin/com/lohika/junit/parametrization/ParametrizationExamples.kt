package com.lohika.junit.parametrization

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

enum class ExampleEnum {
    FIRST,
    SECOND,
    THIRD
}

class ArgumentProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return listOf(of("one", 1), of("one", 2)).stream()
    }
}

class ParametrizationExamples {

    @ParameterizedTest
    @ValueSource(strings = ["foo", "boo"])//, ints = [1, 2])
    fun valueSource(value: String) {
        println("This is value: [$value]")
    }

    @ParameterizedTest
    @NullSource
    fun nullSource(value: String) {
        println("Value should be null: [$value]")
    }

    @ParameterizedTest
    @EmptySource
    fun emptySource(value: List<Int>) {
        println("Value should be empty: [$value]")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun nullAndEmptySource(value: List<Int>?) {
        println("Value should be empty or null: [$value]")
    }

    @ParameterizedTest
    @EnumSource//(names = ["SECOND"], mode = EnumSource.Mode.EXCLUDE)
    fun enumSource(value: ExampleEnum) {
        println("Value should be empty or null: [$value]")
    }

    @ParameterizedTest
    @CsvSource(
        "apple,         1",
        "banana,        2",
        "'lemon, lime', 0xF1",
        "strawberry,    700_000",
    )
    fun csvSource(name: String, value: Int) {
        println("Name is: [$name], value is [$value]")
    }

    @ParameterizedTest
    @CsvSource(
        textBlock =
        """apple       = 1
           banana      = 2
           lemon, lime = 0xF1
           strawberry  = 700_000""",
        delimiter = '=',
    )
    fun csvSource2(name: String, value: Int) {
        println("Name is: [$name], value is [$value]")
    }

    @ParameterizedTest
    @CsvFileSource(
        resources = ["/com/lohika/test.csv"],
        delimiter = ';',
        numLinesToSkip = 1
    )
    fun csvFileSource(name: String, value: Int) {
        println("Name is: [$name], value is [$value]")
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentProvider::class)
    fun argumentSource(name: String, value: Int) {
        println("Name is: [$name], value is [$value]")
    }

}