package com.example.demo.Exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(CustomExceptions.class)
    public ResponseEntity<SimpleResponse> UserExceptions(CustomExceptions exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getSimpleResponse());
    }
}
