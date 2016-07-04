package com.memoizrlabs.kotlin_basics.objects

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class Objects {
    object ThereCanBeOnlyOne

    @Test
    fun objectsAreSingletons() {
        // Make `ThereCanBeOnlyOne` a singleton by making it an object
        assertThat(ThereCanBeOnlyOne, equalTo(ThereCanBeOnlyOne))
    }

    class Duck {
        // convert `quack` to be a static method inside a companion object
        companion object {
            fun quack() = "Quack!"
        }
    }

    @Test
    fun companionObjectsHaveStaticMethods() {
        assertThat(Duck.quack(), equalTo("Quack!"))
    }

}