package com.example.exception;

import java.util.Arrays;
import java.util.List;

/**
 * Default exception class, microservice exception handling
 * should have advice and catch this defined exception to filter
 * which type of error we have.
 */
public class DefaultException extends Exception {

    private List<ErrorDetails> errors;

    public List<ErrorDetails> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetails> errors) {
        this.errors = errors;
    }

    public DefaultException(String code, String msg){
        super(msg);
        this.errors = Arrays.asList(new ErrorDetails(code, msg));
    }

    public DefaultException(List<ErrorDetails> errors){
        super(errors.toString());
        this.errors = errors;
    }

    public boolean add(ErrorDetails errorDetails) {
        return errors.add(errorDetails);
    }
}
