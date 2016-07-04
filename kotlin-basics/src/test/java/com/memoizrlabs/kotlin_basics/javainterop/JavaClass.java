package com.memoizrlabs.kotlin_basics.javainterop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JavaClass {
    @Test
    public void globalFunctions() {
        // Call `globalFunction`
        String globalFunctionResult = null;
        assertThat(globalFunctionResult, equalTo("Hello World"));
    }

    @Test
    public void lastChar() {
        // Call the `appendPrefix` extension function and satisfy the test
        String result = null;
        assertThat(result, equalTo("Oh, hello"));
    }

    @Test
    public void companionObject() {
        // Get the `defaultString` from KotlinClass
        String defaultString = null;
        assertThat(defaultString, equalTo("hello"));
    }

    @Test
    public void jvmOverloads() {
        KotlinClass kotlinClass = new KotlinClass("hey");
        assertThat(kotlinClass.getOptionalConstructorParameter(), equalTo("default value"));
    }
}
