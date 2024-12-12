package com.example.demo.DTO;

import com.example.demo.Models.Art;
import com.example.demo.Models.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
public class ArtDTO extends Art {
    private boolean presetInCart;

    @Data
    @AllArgsConstructor
    public static class BookingDTO extends Booking {
        private UUID art_id;
        private UUID user_id;
    }
}
