package com.example.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client extends User{

    @Email(message = "Please enter a valid email !")
    private String email;
}
