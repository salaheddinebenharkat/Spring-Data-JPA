package com.example.jpa.controllers;

import com.example.jpa.dtos.requestDTO.ClientRequestDTO;
import com.example.jpa.dtos.responseDTO.ClientResponseDTO;
import com.example.jpa.entities.Client;
import com.example.jpa.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping(path = "/add")
    public ClientResponseDTO addClient(@RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.saveClient(clientRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<ClientResponseDTO> getClients(){
        return clientService.getAllClients();
    }

}
