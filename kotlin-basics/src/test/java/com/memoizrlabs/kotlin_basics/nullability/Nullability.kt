package com.memoizrlabs.kotlin_basics.nullability

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class Nullability {
    @Test
    fun nullablility() {
        // Substutute equivalent using elvis operator ?:
        fun getValueOrZeroIfNull(x: Int?): Int = Optional.ofNullable(x).orElseGet { 0 }!!

        assertThat(getValueOrZeroIfNull(88), equalTo(88))
        assertThat(getValueOrZeroIfNull(null), equalTo(0))
    }

    @Test
    fun safeSizeCheck() {
        // Substutute equivalent using safe method call
        fun safeSize(list: List<*>?): Int = Optional.ofNullable(list).map { it!!.size }.orElseGet { 0 }

        assertThat(safeSize(listOf("hey")), equalTo(1))
        assertThat(safeSize(null), equalTo(0))
    }

    @Test
    fun runIfPresentsWithRun() {
        val value: AtomicInteger = AtomicInteger(2)
        fun runIfPresent(x: Int?) = Optional.ofNullable(x).ifPresent { value.incrementAndGet() }
        runIfPresent(0)
        assertThat(value.get(), equalTo(3))
        runIfPresent(null)
        assertThat(value.get(), equalTo(3))
    }

    @Test
    fun let() {
        fun safeAdd(value: Int?) = value?.let { it + 1 } ?: 0
        assertThat(safeAdd(5), equalTo(6))
        assertThat(safeAdd(null), equalTo(0))
    }

    @Test
    fun apply() {
        fun safeUpperCase(value: String?) = value?.apply { toUpperCase() } ?: ""
        assertThat(safeUpperCase("hello"), equalTo("HELLO"))
        assertThat(safeUpperCase(null), equalTo(""))
    }

}