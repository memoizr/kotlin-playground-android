package com.memoizrlabs.kotlin_basics.visibility

class VisibilityAndScope {

    fun memberFunction() {
        fun innerFunction() = {}
        class InnerClass {

        }
    }
    private fun privateMemberFunction() {
    }
}

class OtherClass

fun hello() = "hello"
