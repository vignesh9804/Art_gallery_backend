package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class UsernameNotFound extends CustomExceptions {
    public UsernameNotFound() {
        super(HttpStatus.NOT_FOUND, new SimpleResponse("username not found"));
    }
}
