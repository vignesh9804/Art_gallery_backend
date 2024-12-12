package com.example.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleResponse {
    private String message;
    private String id;

    public SimpleResponse(String mess) {
        this.message = mess;
        this.id = "";
    }
}
