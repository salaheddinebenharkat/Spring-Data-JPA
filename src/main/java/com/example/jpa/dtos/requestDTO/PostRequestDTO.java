package com.example.jpa.dtos.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    private String content;
    private Date timestamp;
    private Long clientId;
}
