package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Art;
import com.example.demo.DTO.CartDTO;
import com.example.demo.Models.User;
import com.example.demo.Repositories.ArtRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteFromCart implements CommandHandler<CartDTO,Void> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtRepository artRepository;

    @Override
    public ResponseEntity<Void> execute(CartDTO cartDTO) {
        System.out.println(cartDTO);
        User user = userRepository.findById(cartDTO.getUser_id()).get();
        List<Art> arts = user.getCart();
        arts.remove(artRepository.findById(cartDTO.getArt_id()).get());
        user.setCart(arts);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
