package com.example.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomExceptions extends RuntimeException{
    private HttpStatus status;
    private SimpleResponse simpleResponse;
}
