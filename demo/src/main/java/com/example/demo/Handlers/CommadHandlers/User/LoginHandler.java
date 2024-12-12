package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Exceptions.User.IncorrectPassword;
import com.example.demo.Exceptions.User.NeedVerification;
import com.example.demo.Exceptions.User.UsernameNotFound;
import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Login;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginHandler implements CommandHandler<Login, User> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseEntity<User> execute(Login login) {

        Optional<User> user = userRepository.findByUsername(login.getUsername());

        if(user.isEmpty())
            throw new UsernameNotFound();

        if(!user.get().getVerified())
            throw new NeedVerification(user.get().getId().toString());

        if(!user.get().getPassword().equals(login.getPassword()))
            throw new IncorrectPassword();

        return ResponseEntity.ok(user.get());
    }
}
