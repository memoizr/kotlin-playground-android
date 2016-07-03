package com.memoizrlabs.kotlin_basics.control_flow

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.*

class ControlFlow {
    @Test
    fun testCombinedConditions() {
        val x = 0
        val result = when (x) {
            0, 1 -> "x == 0 or x == 1"
            else -> "otherwise"
        }
        assertThat(result, equalTo("x == 0 or x == 1"))
    }

    @Test
    fun checksForType() {
        val x = "prefix"
        val hasPrefix = when (x) {
            is String -> x.startsWith("prefix")
            else -> false
        }
        assertThat(hasPrefix, equalTo(true))
    }

    @Test
    fun switch() {
        val x = 0
        when {
            x % 2 != 0 -> print("x is odd")
            x % 2 == 0 -> print("x is even")
            else -> print("x is funny")
        }
    }

    @Test
    fun forloop() {
        for (a in (1..10)) {

        }
    }

    @Test
    fun smartCast() {
        fun test(x: Any) = when(x) {
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
        val x: Int? = null

        val result =  if (x!= null)
            x + 1
        else
            0

    }
}