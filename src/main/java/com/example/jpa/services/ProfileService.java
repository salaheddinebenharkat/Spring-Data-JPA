package com.example.jpa.services;

import com.example.jpa.dtos.requestDTO.ProfileRequestDTO;
import com.example.jpa.dtos.responseDTO.ProfileResponseDTO;
import com.example.jpa.entities.Profile;
import com.example.jpa.repositories.ProfileRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProfileService {

    private final ProfileRepo profileRepo;
    private final ModelMapper modelMapper;


    public ProfileResponseDTO saveProfile(ProfileRequestDTO profileRequestDTO){
        Profile profile = modelMapper.map(profileRequestDTO, Profile.class);
        profile.setCreatedAt(new Date());
        Profile savedProfile = profileRepo.save(profile);
        log.info("Profile: " + profile.getFullName()+" saved successfully !!!" );
        return modelMapper.map(savedProfile, ProfileResponseDTO.class);
    }

    public List<ProfileResponseDTO> getAllProfiles(){
        log.info("Loading profiles list ...");
        return profileRepo.findAll()
                .stream().map(item -> modelMapper.map(item, ProfileResponseDTO.class))
                .collect(Collectors.toList());
    }
}
