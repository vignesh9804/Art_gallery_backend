package com.example.demo.Handlers.QueryHandlers;

import org.springframework.http.ResponseEntity;

public interface QueryHandler<I,O>{
    ResponseEntity<O> execute(I input);
}
