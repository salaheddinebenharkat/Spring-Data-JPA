package com.example.jpa.services;

import com.example.jpa.entities.Profile;
import com.example.jpa.repositories.ProfileRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepo profileRepo;


    public Profile saveProfile(Profile profile){
        profile.setCreatedAt(new Date());
        return profileRepo.save(profile);
    }

    public List<Profile> getAllProfiles(){
        return profileRepo.findAll();
    }
}
