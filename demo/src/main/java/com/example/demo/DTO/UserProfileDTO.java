package com.example.demo.DTO;

import com.example.demo.Models.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private Boolean status;

    private String profileImg;

    public UserProfileDTO getProfile(User user){
        this.setProfileImg(user.getUrl());
        this.setEmail(user.getEmail());
        this.setStatus(user.getVerified());
        this.setUsername(user.getUsername());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        return this;
    }
}
