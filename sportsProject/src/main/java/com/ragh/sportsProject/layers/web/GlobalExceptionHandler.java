package com.ragh.sportsProject.layers.web;

import com.ragh.sportsProject.layers.exceptions.ApplicationException;
import com.ragh.sportsProject.layers.exceptions.DataNotFoundException;
import com.ragh.sportsProject.layers.exceptions.SemanticException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleDtaNotFoundException (DataNotFoundException exception){
        return new ErrorMessage((exception.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleSemanticException (SemanticException exception){
        return new ErrorMessage((exception.getMessage()));
    }


    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleGeneralException (ApplicationException exception){
        return new ErrorMessage((exception.getMessage()));
    }
}
