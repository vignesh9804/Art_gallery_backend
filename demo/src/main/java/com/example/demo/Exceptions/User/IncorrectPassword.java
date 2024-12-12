package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class IncorrectPassword extends CustomExceptions {
    public IncorrectPassword() {
        super(HttpStatus.NOT_FOUND, new SimpleResponse("incorrect password"));
    }
}
