package com.example.jpa.repositories;

import com.example.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    // 1
    public List<User> findAll();
}
