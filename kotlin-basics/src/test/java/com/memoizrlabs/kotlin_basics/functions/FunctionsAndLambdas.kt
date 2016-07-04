package com.memoizrlabs.kotlin_basics.functions

import com.memoizrlabs.kotlin_basics.todo
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

val globalValue = "I'm a default parameter"


class FunctionsAndLambdas {

    @Test
    fun verifyHelloWorld() {
        assertThat(helloWorld(), equalTo("Hello World"))
    }

    private fun helloWorld(): String {
        return TODO("Make this function return Hello World")
    }

    @Test
    fun verifyCorrectDefaultArgument() {
        assertThat(functionWithDefaultArgument("hello"), equalTo("hello"))
        assertThat(functionWithDefaultArgument(), equalTo(globalValue))
    }

    private fun functionWithDefaultArgument(value: String = TODO("Substitute with default parameter")): String {
        return TODO("Return the value unchanged")
    }

    @Test
    fun lambdas() {
        val multiply: (Int, Int) -> Int = { a, b -> a * b }
        assertThat(multiply(4, 4), equalTo(16))

        val add: (Int, Int) -> Int = todo("Substitute with a lambda that adds two ints")
        assertThat(add(1, 2), equalTo(3))

        val square: (Int) -> Int = todo("Substitute with a lambda that squares a number. You can use 'it' when the lambda only needs one param")
        assertThat(square(5), equalTo(25))
    }

    @Test
    fun lambdaAsLastParameter() {
        // you can pass the last parameter outside of the parenthesis. Modify the expression below to use that idiom.
        val addition = processTwoInts("addition", { a, b -> a - b })

        assertThat(addition, equalTo("Result for addition: 4"))
    }

    private fun processTwoInts(description: String, processingFunction: (Int, Int) -> Int) = "Result for $description: ${processingFunction(2, 2)}"
}

