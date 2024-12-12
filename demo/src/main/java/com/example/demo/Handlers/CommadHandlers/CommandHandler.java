package com.example.demo.Handlers.CommadHandlers;

import org.springframework.http.ResponseEntity;

public interface CommandHandler <I,O>{
    ResponseEntity<O> execute(I input);
}
