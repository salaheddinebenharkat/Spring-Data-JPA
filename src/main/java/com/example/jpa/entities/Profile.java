package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {

    //@GeneratedValue(generator = "profile_seq")
    //@SequenceGenerator(name = "profile_seq", sequenceName = "profile_seq", allocationSize = 1)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(updatable = false)
    private Date createdAt;

    @Embedded
    private Address address;

}
