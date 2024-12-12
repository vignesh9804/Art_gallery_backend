package com.example.demo.Handlers.QueryHandlers;

import com.example.demo.Models.Art;
import com.example.demo.DTO.ArtDTO;
import com.example.demo.DTO.CartDTO;
import com.example.demo.Models.User;
import com.example.demo.Repositories.ArtRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetArt implements QueryHandler<CartDTO, ArtDTO>{

    @Autowired
    ArtRepository artRepository;

    @Autowired UserRepository userRepository;

    @Override
    public ResponseEntity<ArtDTO> execute(CartDTO cartDTO) {

        Art art = artRepository.findById(cartDTO.getArt_id()).get();

        User user = userRepository.findById(cartDTO.getUser_id()).get();

        ArtDTO artDTO = new ArtDTO();
        artDTO.setId(art.getId());
        artDTO.setCost(art.getCost());
        artDTO.setName(art.getName());
        artDTO.setCategory(art.getCategory());
        artDTO.setUrl(art.getUrl());
        artDTO.setSoldOutArt(art.getSoldOutArt());
        artDTO.setArtistName(art.getArtistName());
        artDTO.setDescription(art.getDescription());
        artDTO.setPresetInCart(user.getCart().contains(art));

        System.out.println(artDTO);
        return ResponseEntity.ok(artDTO);
    }
}
