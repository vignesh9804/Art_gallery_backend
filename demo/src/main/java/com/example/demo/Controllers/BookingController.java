package com.example.demo.Controllers;

import com.example.demo.DTO.ArtDTO;
import com.example.demo.DTO.CartDTO;
import com.example.demo.Exceptions.CustomExceptions;
import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Exceptions.User.UsernameNotFound;
import com.example.demo.Models.*;
import com.example.demo.Repositories.ArtRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired private UserRepository userRepository;
    @Autowired private ArtRepository artRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Set<Booking>> getAllBookedIems(@PathVariable UUID id){

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new CustomExceptions(HttpStatus.BAD_REQUEST, new SimpleResponse("user found"));
        System.out.println(user.get().getBookings());
        return ResponseEntity.ok(user.get().getBookings());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addToBooking(@RequestBody ArtDTO.BookingDTO bookingDTO){

        Optional<User> user = userRepository.findById(bookingDTO.getUser_id());
        Optional<Art> art = artRepository.findById(bookingDTO.getArt_id());

        if(user.isEmpty())
            throw new UsernameNotFound();

        if(art.isEmpty())
            throw new CustomExceptions(HttpStatus.BAD_REQUEST, new SimpleResponse("art not found"));

        Booking booking = new Booking();

        art.get().setSoldOutArt(true);
        artRepository.save(art.get());
        System.out.println(art.get());

        booking.setArt(art.get());
        booking.setUser(user.get());
        booking.setId(UUID.randomUUID());
        booking.setDate(LocalDate.now());

        booking.setDelevied(false);
        booking.setDeliveryDate(booking.getDate().plusDays(new Random().nextInt(5) +1));

        booking.setPincode(bookingDTO.getPincode());
        booking.setState(bookingDTO.getState());
        booking.setDoorNo(bookingDTO.getDoorNo());
        booking.setTown(bookingDTO.getTown());
        booking.setStreet(bookingDTO.getStreet());

        booking.setCost(art.get().getCost());
        user.get().getBookings().add(booking);

        userRepository.save(user.get());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBookingItem(@RequestBody CartDTO cartDTO) {

        Optional<User> user = userRepository.findById(cartDTO.getUser_id());

        if (user.isEmpty())
            throw new UsernameNotFound();

        Set<Booking> bookings = user.get().getBookings();
        bookings.removeIf(b -> {
            if(b.getId().equals(cartDTO.getArt_id())){
                Art art = b.getArt();
                art.setSoldOutArt(false);
                artRepository.save(art);
                return true;
            }
            return false;
        });

        userRepository.save(user.get());

        return ResponseEntity.ok("SucessFully deleted");
    }

}
