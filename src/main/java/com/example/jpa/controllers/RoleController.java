package com.example.jpa.controllers;

import com.example.jpa.entities.Role;
import com.example.jpa.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping(path = "/add")
    public Role addRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    @GetMapping(path = "/all")
    public List<Role> getAllRoles(){
        return roleService.getRoles();
    }
}
