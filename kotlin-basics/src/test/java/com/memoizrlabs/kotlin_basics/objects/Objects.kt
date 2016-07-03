package com.memoizrlabs.kotlin_basics.objects

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class Objects {
    object ThereCanBeOnlyOne

    @Test
    fun objectsAreSingletons() {
        assertThat(ThereCanBeOnlyOne, equalTo(ThereCanBeOnlyOne))
    }

    @Test
    fun companionObjectsHaveStaticMethods() {
        val duck = Duck.duck
        val name = Duck.name
    }

    class Duck {
        companion object {
            fun quack() = "Quack!"
            const val name = "duck"
            @JvmField val duck = Duck()
        }
    }
}