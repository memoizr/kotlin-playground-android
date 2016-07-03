package com.memoizrlabs.kotlin_basics.autoconversion;


import java.io.Serializable;

public class test2 extends Exception implements Serializable {
    private final String customMessage;
    private Exception customCause;

    public test2(String message) {
        super(message);
        this.customMessage = message;
        this.customCause = this;
    }

    public test2(String customMessage, Exception customCause) {
        super(customMessage, customCause);
        this.customMessage = customMessage;
        this.customCause = customCause;
    }

    public String sayHello(String user) {
        return "Hello " + user;
    }
}
