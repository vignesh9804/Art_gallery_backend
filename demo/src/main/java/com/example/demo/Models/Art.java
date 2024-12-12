package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "arts")
@Data
public class Art {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "art_name")
    private String name;

    @Column(name = "artist_name")
    private String artistName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "category")
    private String category;

    @Column(name = "url")
    private String url;

    @Column(name = "sold_out")
    private Boolean soldOutArt;

    @ManyToMany(mappedBy = "cart")
    @JsonIgnore
    private List<User> users;
}
