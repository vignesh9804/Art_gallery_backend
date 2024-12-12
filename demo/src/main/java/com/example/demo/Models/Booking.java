package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Data
@EqualsAndHashCode(exclude = {"user", "art"})
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "booking_date")
    private LocalDate date;

    @Column(name = "street")
    private String street;

    @Column(name = "town")
    private String town;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "doorNO")
    private String doorNo;

    @Column(name = "State")
    private String state;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "delevied")
    private Boolean delevied;

    @Column(name = "deliverydate")
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @OneToOne
    @JoinColumn(name = "art_id")
    private Art art;
}
