package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUser implements CommandHandler<UUID, Void> {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Void> execute(UUID id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
