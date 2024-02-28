package com.example.jpa.dtos.requestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

    private String username;
    private String password;
    private Long profileId;
    private String email;

}
