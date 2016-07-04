package com.memoizrlabs.kotlin_basics.extension

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class Extensions {
    @Test
    fun lastChar() {
        fun String.lastChar(): Char = last()

        assertThat("hello".lastChar(), equalTo('o'))
    }

    @Test
    fun copyOnWrite() {
        val mutableList = mutableListOf(1,2)
        class Inner(list: MutableList<Int>) {
            val list = list.safeCopy()
        }

        val inner = Inner(mutableList)
        mutableList[0] = 3
        assertThat(inner.list[0], equalTo(1))
    }

    fun <T> MutableList<T>.safeCopy() : MutableList<T> = mutableListOf<T>().apply { addAll(this@safeCopy) }
}