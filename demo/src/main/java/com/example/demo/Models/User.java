package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"bookings"})
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "otp")
    private String otp;

    @Column(name = "verified")
    private Boolean verified;

    @Column(name = "url")
    private String url;

    @ManyToMany
    @JoinTable(
            name = "cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "art_id")
    )
    private List<Art> cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Booking> bookings;
}
