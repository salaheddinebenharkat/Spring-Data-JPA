package com.example.jpa.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

    private String city;
    private String street;
    private String country;
}
