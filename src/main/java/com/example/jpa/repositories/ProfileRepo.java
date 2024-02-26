package com.example.jpa.repositories;

import com.example.jpa.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    // 4
    public Profile updateProfileByUser(Long userId, String fullName);
}
