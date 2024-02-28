package com.example.jpa.controllers;

import com.example.jpa.dtos.requestDTO.ProfileRequestDTO;
import com.example.jpa.dtos.responseDTO.ProfileResponseDTO;
import com.example.jpa.entities.Profile;
import com.example.jpa.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping(path = "/add")
    public ProfileResponseDTO addProfile(@RequestBody ProfileRequestDTO profileRequestDTO){
        profileRequestDTO.setCreatedAt(new Date());
        return profileService.saveProfile(profileRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<ProfileResponseDTO> getProfiles(){
        return profileService.getAllProfiles();
    }
}
