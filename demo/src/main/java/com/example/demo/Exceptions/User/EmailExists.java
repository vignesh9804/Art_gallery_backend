package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class EmailExists extends CustomExceptions {
    public EmailExists() {
        super(HttpStatus.FOUND, new SimpleResponse("email already exits"));
    }
}
