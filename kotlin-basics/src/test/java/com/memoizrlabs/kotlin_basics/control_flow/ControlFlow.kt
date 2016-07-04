package com.memoizrlabs.kotlin_basics.control_flow

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.*

class ControlFlow {

    @Test
    fun testCombinedConditions() {
        // Change the appropriate branch to make it return the expected value
        val x = 0
        val result = when (x) {
            0, 1 -> "x == 0 or x == 1"
            else -> "otherwise"
        }
        assertThat(result, equalTo("x == 0 or x == 1"))
    }

    @Test
    fun checksForType() {
        // Change the value of `x` to satisfy the test
        val x: Any = "prefix string"

        val hasPrefix = when (x) {
            is String -> x.startsWith("prefix")
            else -> false
        }
        assertThat(hasPrefix, equalTo(true))
    }

    @Test
    fun switch() {
        val x = 2
        val switchTest = when {
            x % 2 != 0 -> "x is odd"
        // Add an even test branch, and make it return the expected value
            x % 2 == 0 -> "x is even"
            else -> "x is funny"
        }

        assertThat(switchTest, equalTo("x is even"))
    }

    @Test
    fun forLoopTo() {
        val mutableList = mutableListOf<Int>()
        for (item in (1..5)) {
            // Append all items to the list one by one
            mutableList.add(item)
        }
        assertThat(mutableList, equalTo(mutableListOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun forloopUntil() {
        val mutableList = mutableListOf<Int>()
        for (item in (1 until 5)) {
            // Append all items to the list one by one
            mutableList.add(item)
        }
        assertThat(mutableList, equalTo(mutableListOf(1, 2, 3, 4)))
    }

    @Test
    fun smartCast() {
        // Satisfy the tests, notice how the types are inferred
        fun test(x: Any) = when (x) {
            is Int -> x + 1
            is String -> x.toUpperCase()
            is List<*> -> x.first()
            else -> x
        }

        val testInt = Random().nextInt(100)
        assertThat(test(testInt) as Int, equalTo(testInt + 1))

        val testString = UUID.randomUUID().toString()
        assertThat(test(testString) as String, equalTo(testString.toUpperCase()))

        val testList = listOf(testString)
        assertThat(test(testList) as String, equalTo(testList.first()))
    }

    @Test
    fun smartCastIf() {
        val x: Int? = 2

        // Add one to x, notice the type is inferred
        val result = if (x != null) x + 1 else 0

        assertThat(result, equalTo(3))
    }
}