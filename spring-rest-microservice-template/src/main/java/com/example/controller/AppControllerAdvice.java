package com.example.controller;

import com.example.exception.DefaultException;
import com.example.exception.ErrorDetails;
import com.example.util.SimpleLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: Victor
 *
 * Advice catches exceptions from application, Any Throwable is filtered as 500 error
 * and returns service_exception. Any DefaultException is returned as 400 and
 * gives a different code and message.
 */
@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity exceptions(Throwable t){
        SimpleLogger.info("Exception found! %s ", t.getMessage());
        t.printStackTrace();

        return new ResponseEntity<>(
                new ErrorDetails("service_exception",
                        t.getMessage()) , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorDetails[]> defaultException(DefaultException e){
        return new ResponseEntity(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
}