package com.example.jpa.controllers;

import com.example.jpa.entities.Profile;
import com.example.jpa.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping(path = "/add")
    public Profile addProfile(@RequestBody Profile profile){
        return profileService.saveProfile(profile);
    }

    @GetMapping(path = "/all")
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }
}
