package com.example.jpa.dtos.responseDTO;

import com.example.jpa.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDTO {

    private Long id;
    private String fullName;
    private Date createdAt;
    private Address address;
}
