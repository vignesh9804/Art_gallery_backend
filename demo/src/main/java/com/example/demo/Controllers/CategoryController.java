package com.example.demo.Controllers;

import com.example.demo.Handlers.CommadHandlers.Category.AddCategory;
import com.example.demo.Handlers.CommadHandlers.Category.DeleteCategory;
import com.example.demo.Handlers.QueryHandlers.GetCategory;
import com.example.demo.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired private GetCategory getCategory;
    @Autowired private AddCategory addCategory;
    @Autowired private DeleteCategory deleteCategory;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return getCategory.execute(null);
    }

    @PostMapping
    public ResponseEntity<Void> addNewCategory(@RequestBody Category category){
        return addCategory.execute(category);
    }

    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody Category category){
        return addCategory.execute(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteACategory(@PathVariable UUID id ){
        return deleteCategory.execute(id);
    }
}
