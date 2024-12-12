package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Art;
import com.example.demo.DTO.CartDTO;
import com.example.demo.Models.User;
import com.example.demo.Repositories.ArtRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddToCart implements CommandHandler<CartDTO, SimpleResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtRepository artRepository;

    @Override
    public ResponseEntity<SimpleResponse> execute(CartDTO cartDTO) {
        User user =  userRepository.findById(cartDTO.getUser_id()).get();
        Art art = artRepository.findById(cartDTO.getArt_id()).get();

        if(user.getCart().contains(art))
            throw new CustomExceptions(HttpStatus.BAD_REQUEST, new SimpleResponse("art already exits"));

        user.getCart().add(art);
        userRepository.save(user);
        return ResponseEntity.ok(new SimpleResponse("Added to cart"));
    }
}