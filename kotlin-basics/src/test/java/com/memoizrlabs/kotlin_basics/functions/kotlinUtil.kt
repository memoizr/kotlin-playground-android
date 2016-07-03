package com.memoizrlabs.kotlin_basics.functions

class NotImplementedException(message: String): Exception(message)

fun todo(task: String): Nothing = throw NotImplementedException(task)
