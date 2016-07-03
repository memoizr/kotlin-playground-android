package com.memoizrlabs.kotlin_basics.autoconversion;

import java.io.Serializable;

public class ClassToConvert extends Exception implements Serializable {
    private final String message;
    private Throwable cause = this;

    public ClassToConvert(String message) {
        super(message);
        this.message = message;
    }

    public ClassToConvert(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public String sayHello(String user) {
        return "Hello " + user;
    }
}
