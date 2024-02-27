package com.example.jpa.repositories;

import com.example.jpa.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    // 4
    @Query("""
            UPDATE Profile  p
            SET p.fullName = :fullName
            WHERE p.id = :userId
            """)
    public Profile userFullNameUpdate(Long userId, String fullName);
}
