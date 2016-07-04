package com.memoizrlabs.kotlin_basics.objects

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class Objects {
    class ThereCanBeOnlyOne()

    @Test
    fun objectsAreSingletons() {
        // Make `ThereCanBeOnlyOne` a singleton by making it an object
        assertThat(ThereCanBeOnlyOne(), equalTo(ThereCanBeOnlyOne()))
    }

    @Test
    fun companionObjectsHaveStaticMethods() {
        class Duck {
            // convert `quack` to be a static method inside a companion object
            fun quack() = "Quack!"
        }
        assertThat(Duck().quack(), equalTo("Quack!"))
    }

}