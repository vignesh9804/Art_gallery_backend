package com.example.demo.Handlers.QueryHandlers;


import com.example.demo.Models.Category;
import com.example.demo.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategory implements QueryHandler<Void, List<Category>> {

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<Category>> execute(Void input) {
        return ResponseEntity.ok(categoryRepository.findAll());
    }
}
