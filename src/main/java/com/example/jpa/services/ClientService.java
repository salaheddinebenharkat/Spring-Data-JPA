package com.example.jpa.services;

import com.example.jpa.dtos.requestDTO.ClientRequestDTO;
import com.example.jpa.dtos.responseDTO.ClientResponseDTO;
import com.example.jpa.entities.Client;
import com.example.jpa.entities.Profile;
import com.example.jpa.entities.Role;
import com.example.jpa.repositories.ClientRepo;
import com.example.jpa.repositories.ProfileRepo;
import com.example.jpa.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClientService {



    private final ModelMapper modelMapper;
    private final ClientRepo clientRepo;
    private final ProfileRepo profileRepo;


    public ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO){
        Client client = modelMapper.map(clientRequestDTO, Client.class);
        Profile profile = profileRepo.findById(clientRequestDTO.getProfileId()).get();
        client.setProfile(profile);
        Client savedClient = clientRepo.save(client);
        log.info("Client: "+client.getUsername()+" saved successfully !!!");
        return modelMapper.map(savedClient, ClientResponseDTO.class);
    }

    public List<ClientResponseDTO> getAllClients(){
        log.info("Loading clients list ...");
        return clientRepo.findAll()
                .stream().map(item -> modelMapper.map(item, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }

}
