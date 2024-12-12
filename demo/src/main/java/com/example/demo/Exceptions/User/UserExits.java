package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class UserExits extends CustomExceptions {
    public UserExits() {
        super(HttpStatus.FOUND, new SimpleResponse("username already exits"));
    }
}
