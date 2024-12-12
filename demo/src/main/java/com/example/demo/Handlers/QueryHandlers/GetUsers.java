package com.example.demo.Handlers.QueryHandlers;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsers implements QueryHandler<Void, List<User>> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<User>> execute(Void input) {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
