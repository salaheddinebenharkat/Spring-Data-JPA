package com.example.jpa.services;

import com.example.jpa.entities.Profile;
import com.example.jpa.repositories.ProfileRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProfileService {

    private final ProfileRepo profileRepo;


    public Profile saveProfile(Profile profile){
        log.info("Creating new profile " + profile.getFullName() );
        profile.setCreatedAt(new Date());
        return profileRepo.save(profile);
    }

    public List<Profile> getAllProfiles(){
        log.info("Loading profiles list ...");
        return profileRepo.findAll();
    }
}
