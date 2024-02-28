package com.example.jpa.services;

import com.example.jpa.dtos.requestDTO.RoleRequestDTO;
import com.example.jpa.dtos.responseDTO.RoleResponseDTO;
import com.example.jpa.entities.Role;
import com.example.jpa.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;


    public RoleResponseDTO saveRole(RoleRequestDTO roleRequestDTO){
        Role role = modelMapper.map(roleRequestDTO, Role.class);
        log.info("Saving new role => "+ role.getRole());
        Role savedRole = roleRepo.save(role);
        return modelMapper.map(savedRole, RoleResponseDTO.class);
    }

    public List<RoleResponseDTO> getRoles(){
        log.info("Getting roles list ...");
        return roleRepo.findAll()
                .stream().map(item -> modelMapper.map(item, RoleResponseDTO.class))
                .collect(Collectors.toList());
    }

    public RoleResponseDTO getRoleById(Long roleId){
        Role role = roleRepo.findById(roleId).orElseThrow(()-> new RuntimeException("Role with the id : "+roleId+" not found !"));
        return modelMapper.map(role, RoleResponseDTO.class);
    }

    public RoleResponseDTO updateRole(RoleRequestDTO roleRequestDTO){
        return new RoleResponseDTO();
    }

    public void deleteRoleById(Long roleId){
        roleRepo.deleteById(roleId);
    }

}
