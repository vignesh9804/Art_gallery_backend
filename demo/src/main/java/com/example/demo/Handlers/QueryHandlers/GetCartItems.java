package com.example.demo.Handlers.QueryHandlers;

import com.example.demo.Models.Art;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetCartItems implements QueryHandler<UUID, List<Art>>{

    @Autowired private UserRepository userRepository;

    @Override
    public ResponseEntity<List<Art>> execute(UUID id) {
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok(user.getCart());
    }
}
