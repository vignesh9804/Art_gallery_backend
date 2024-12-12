package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Verification {
    private UUID id;
    private String email;
    private String otp;
}
