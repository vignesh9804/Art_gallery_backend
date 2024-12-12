package com.example.demo.Handlers.QueryHandlers;

import com.example.demo.Models.Art;
import com.example.demo.Repositories.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArts implements QueryHandler<Void, List<Art>>{
    @Autowired
    ArtRepository artRepository;

    @Override
    public ResponseEntity<List<Art>> execute(Void input) {
        return ResponseEntity.ok(artRepository.findAll());
    }
}
