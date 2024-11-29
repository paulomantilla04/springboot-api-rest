package com.application.rest.SpringBootRestFootball.controllers.dto;

import com.application.rest.SpringBootRestFootball.entities.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {

    private Long id;
    private String name;
    private int age;
    private int number;
    private int goals;
    private int assists;
    private boolean status;
    private Club club;
}
