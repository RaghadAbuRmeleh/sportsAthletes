package com.ragh.sportsProject.layers.exceptions;

//CUSTOM EXCEPTION MUST BE EXTENDED FROM RUNTIMEEXCEPTION
public class ApplicationException extends RuntimeException{
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }
}
