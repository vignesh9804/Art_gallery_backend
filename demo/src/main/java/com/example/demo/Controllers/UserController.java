package com.example.demo.Controllers;

import com.example.demo.DTO.CartDTO;
import com.example.demo.DTO.UserProfileDTO;
import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Exceptions.User.UserExits;
import com.example.demo.Handlers.CommadHandlers.User.*;
import com.example.demo.Handlers.QueryHandlers.GetCartItems;
import com.example.demo.Models.*;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private LoginHandler loginHandler;

    @Autowired
    private CreateUser createUser;

    @Autowired
    private VerifyUser verifyUser;

    @Autowired
    private DeleteFromCart deleteFromCart;

    @Autowired
    private AddToCart addToCart;

    @Autowired
    private GetCartItems getCartItems;

    @PostMapping
    public ResponseEntity<SimpleResponse> siginUser(@RequestBody User user){
        System.out.println(user);
        return createUser.execute(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> LoginUser(@RequestBody Login login){
        System.out.println(login);
        return loginHandler.execute(login);
    }

    @PostMapping("/verify")
    public ResponseEntity verify(@RequestBody Verification verification){
        return verifyUser.execute(verification);
    }


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable UUID id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAllUsers(){
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteFromcart")
    public ResponseEntity deleteFromUserCart(@RequestBody CartDTO cartDTO){
        return deleteFromCart.execute(cartDTO);
    }

    @PostMapping("/cart")
    public ResponseEntity<SimpleResponse> addToUserCart(@RequestBody CartDTO cartDTO){
        return addToCart.execute(cartDTO);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<List<Art>> getCartItem(@PathVariable UUID id){
        return getCartItems.execute(id);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileDTO> getDetails(@PathVariable UUID id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserExits();
        return ResponseEntity.ok(new UserProfileDTO().getProfile(user.get()));
    }
}
