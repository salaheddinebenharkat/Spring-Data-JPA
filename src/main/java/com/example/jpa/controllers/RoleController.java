package com.example.jpa.controllers;

import com.example.jpa.dtos.requestDTO.RoleRequestDTO;
import com.example.jpa.dtos.responseDTO.RoleResponseDTO;
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
    public RoleResponseDTO addRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return roleService.saveRole(roleRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<RoleResponseDTO> getAllRoles(){
        return roleService.getRoles();
    }
}


