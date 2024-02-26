package com.example.jpa.repositories;

import com.example.jpa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepo extends JpaRepository<Client, UUID> {

    // 2
    public List<Client> findAll();

}
