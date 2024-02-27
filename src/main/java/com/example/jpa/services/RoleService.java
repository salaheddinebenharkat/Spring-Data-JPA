package com.example.jpa.services;

import com.example.jpa.entities.Role;
import com.example.jpa.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepo roleRepo;


    public Role saveRole(Role role){
        log.info("Saving new role => "+ role.getRole());
        return roleRepo.save(role);
    }


    public List<Role> getRoles(){
        log.info("Getting roles list ...");
        return roleRepo.findAll();
    }
}
