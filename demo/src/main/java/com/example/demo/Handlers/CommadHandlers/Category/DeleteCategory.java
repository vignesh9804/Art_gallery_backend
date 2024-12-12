package com.example.demo.Handlers.CommadHandlers.Category;

import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.Category;
import com.example.demo.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCategory implements CommandHandler<UUID, Void> {

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<Void> execute(UUID id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
