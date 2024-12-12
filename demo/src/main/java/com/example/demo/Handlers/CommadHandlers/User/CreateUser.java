package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Exceptions.User.UserExits;
import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Art;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CreateUser implements CommandHandler<User, SimpleResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<SimpleResponse> execute(User user) {

        if(!userRepository.findByUsername(user.getUsername()).isEmpty())
            throw new UserExits();

        List<Art> arts = new ArrayList<>();
        user.setCart(arts);
        user.setRole("user");
        user.setId(UUID.randomUUID());
        user.setEmail("");
        user.setVerified(false);
        user.setOtp("");

        userRepository.save(user);
        System.out.println(new SimpleResponse(user.getId().toString()));
        return ResponseEntity.ok(new SimpleResponse(user.getId().toString()));
    }
}
