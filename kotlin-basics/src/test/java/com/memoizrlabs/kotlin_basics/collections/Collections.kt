package com.memoizrlabs.kotlin_basics.collections

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.*
import org.junit.Test

class Collections {

    @Test
    fun map() {
        // Use map to increase each by one
        val list = listOf(1, 2, 3, 4, 5, 6)//.map { it + 1 }

        assertThat(list, equalTo(listOf(2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun first() {

        // use `first` to get the first element
        val first = listOf(1, 2, 3, 4, 5, 6)//.first()

        assertEquals(1, first)
    }

    @Test
    fun flatMap() {
        // Use `flatMap` to convert the list into list below
        val list = listOf(1, 2)//.flatMap { listOf("$it one", "$it two") }

        assertEquals(listOf("1 one", "1 two", "2 one", "2 two"), list)
    }

    @Test
    fun all() {
        // Use `all` to check all numbers in list are greater than zero
        val allGreaterThanZero = listOf(1,2,3,0)
        assertEquals(false, allGreaterThanZero)
    }

    @Test
    fun any() {
        // Use `any` to check any number in the list is smaller than zero
        val anySmallerThanZero = listOf(1,2,3,-1)
        assertEquals(true, anySmallerThanZero)
    }
}