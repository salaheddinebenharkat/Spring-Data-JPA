package com.example.jpa.services;

import com.example.jpa.dtos.requestDTO.ClientRequestDTO;
import com.example.jpa.dtos.responseDTO.ClientResponseDTO;
import com.example.jpa.entities.Client;
import com.example.jpa.entities.Role;
import com.example.jpa.repositories.ClientRepo;
import com.example.jpa.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {



    private final ModelMapper modelMapper;
    private final ClientRepo clientRepo;
    private final RoleRepo roleRepo;


    public ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO, Integer roleId){
        Role role = roleRepo.findById(roleId).orElseThrow(()-> new RuntimeException("Role not found !"));
        Client client = modelMapper.map(clientRequestDTO, Client.class);
        client.getRoles().add(role);

        System.out.println(role.getRole());

        System.out.println(client.getRoles().size());

        Client savedClient = clientRepo.save(client);
        return modelMapper.map(savedClient, ClientResponseDTO.class);
    }

    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

}
