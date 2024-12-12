package com.example.demo.Handlers.CommadHandlers.Category;

import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Category;
import com.example.demo.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddCategory implements CommandHandler<Category, Void> {

    @Autowired private CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<Void> execute(Category category) {
        if(category.getId() == null)
            category.setId(UUID.randomUUID());
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }
}
