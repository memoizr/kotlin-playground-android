package com.memoizrlabs.kotlin_basics.classes

import com.memoizrlabs.kotlin_basics.todo
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test


class Classes {
    interface AnInterface

    @Test
    fun inheritance() {
        open class AClass

        //Make AChildClass implementAnInterface and AClass
        class AChildClass// : AnInterface, AClass()

        assertTrue(AnInterface::class.java.isInstance(AChildClass()))
        assertTrue(AClass::class.java.isInstance(AChildClass()))
    }

    // Interfaces in Kotlin are like Java8 interfaces, stateless but with implementations
    interface SimpleInterface {
        fun helloWorld(): String =  todo("substitute with Hello World") // "Hello World"
    }

    @Test
    fun defaultImplementationOfInterface() {
        class AChildClass: SimpleInterface
        assertThat(AChildClass().helloWorld(), equalTo("Hello World"))
    }

    @Test
    fun dataClasses() {
        // Make ADataClass a data class

        class ADataClass(val data: String)

        assertTrue(ADataClass("data") == ADataClass("data"))
    }

    @Test
    fun copy(){
        data class User(val name: String, val height: Int)
        val john = User("john", 178)
        // Create a copy of john, change the height to be 180
        val updatedUser = john//.copy(height = 180)
        assertTrue(updatedUser.height == 180)
    }

    @Test
    fun secondaryConstructors() {
        class SecondaryClass(val integer: Int) {
            // Call the super constructor with "42" instead of 0
            constructor(string: String) : this(0)
        }
        assertThat(SecondaryClass("hello").integer, equalTo(42))
    }

    @Test
    fun initBlock() {
        class SecondaryClass(value: String) {
            val value: String
            init {
                // convert value to upper case
                this.value = value// .toUpperCase
            }
        }
        assertThat(SecondaryClass("hello").value, equalTo("HELLO"))
    }
}
