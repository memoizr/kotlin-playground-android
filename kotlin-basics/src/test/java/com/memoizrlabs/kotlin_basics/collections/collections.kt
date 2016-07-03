package com.memoizrlabs.kotlin_basics.collections

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class collections {
    @Test
    fun map() {
        val list = listOf(1, 2, 3, 4, 5, 6).map { it + 1 }

        assertThat(list, equalTo(listOf(2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun first() {
        val first = listOf(1, 2, 3, 4, 5, 6).first()

        assertThat(first, equalTo(1))
    }

    @Test
    fun flatmap() {
        val list = listOf(1, 2).flatMap { listOf(8, 9) }

        assertThat(list, equalTo(listOf(8, 9, 8, 9)))
    }
}