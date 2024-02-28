package com.example.jpa.dtos.responseDTO;


import com.example.jpa.entities.Profile;
import com.example.jpa.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String username;
    private String password;
    private Profile profile;
    private String email;
    private List<Role> roles;

}
