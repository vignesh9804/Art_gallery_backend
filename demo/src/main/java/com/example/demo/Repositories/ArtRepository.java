package com.example.demo.Repositories;

import com.example.demo.Models.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArtRepository extends JpaRepository<Art, UUID> {
    List<Art> findByCategory(String cat);
}
