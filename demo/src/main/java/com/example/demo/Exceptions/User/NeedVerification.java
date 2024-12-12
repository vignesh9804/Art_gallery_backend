package com.example.demo.Exceptions.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;

public class NeedVerification extends CustomExceptions {
    public NeedVerification(String id) {
        super(HttpStatus.BAD_REQUEST, new SimpleResponse("verification requried", id));
    }
}
