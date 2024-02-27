package com.example.jpa.services;

import com.example.jpa.entities.Role;
import com.example.jpa.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;


    public Role saveRole(Role role){
        return roleRepo.save(role);
    }


    public List<Role> getRoles(){
        return roleRepo.findAll();
    }
}
