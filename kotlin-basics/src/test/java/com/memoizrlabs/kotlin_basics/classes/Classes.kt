package com.memoizrlabs.kotlin_basics.classes

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class Classes {
    @Test
    fun inheritance() {
        assertTrue(AChildClass() is AnInterface)
        assertTrue(AChildClass() is AClass)
    }

    @Test
    fun dataClasses() {
        assertTrue(ADataClass("data") == ADataClass("data"))
    }

    @Test
    fun copy(){
        val john = User("john", 178)
        // Create a copy of john, change the height to be 180
        val updatedUser = john.copy(height = 180)
        assertTrue(updatedUser.height == 180)
    }

    @Test
    fun secondaryConstructors() {
        class SecondaryClass(val integer: Int) {
            constructor(sting: String) : this(42)
        }
        assertThat(SecondaryClass("hello").integer, equalTo(42))
    }

    @Test
    fun initBlock() {
        class SecondaryClass(value: String) {
            val value: String
            init {
                this.value = value.toUpperCase()
            }
        }
        assertThat(SecondaryClass("hello").value, equalTo("HELLO"))
    }

    @Test
    fun initBlock2() {
        class SecondaryClass(value: String) {
            val value: String
            init {
                this.value = value.toUpperCase()
            }
        }
        assertThat(SecondaryClass("hello").value, equalTo("HELLO"))
    }

    interface AnInterface
    open class AClass
    class AChildClass : AnInterface, AClass()

    data class ADataClass(val data: String)
    data class User(val name: String, val height: Int)
}
