package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CartDTO {
    private UUID art_id;
    private UUID user_id;
}
