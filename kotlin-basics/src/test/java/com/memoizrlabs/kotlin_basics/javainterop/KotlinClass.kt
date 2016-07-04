package com.memoizrlabs.kotlin_basics.javainterop

class KotlinClass @JvmOverloads constructor(
        val mandatoryParameter: String,
        val optionalConstructorParameter: String = "default value") {
    companion object {
        @JvmField val defaultString = "hello"
    }
}