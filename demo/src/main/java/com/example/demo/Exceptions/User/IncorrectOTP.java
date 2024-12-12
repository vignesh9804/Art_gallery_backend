package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class IncorrectOTP extends CustomExceptions {
    public IncorrectOTP() {
        super(HttpStatus.BAD_REQUEST, new SimpleResponse("Incorrect OTP.."));
    }
}
