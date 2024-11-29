package com.application.rest.SpringBootRestFootball.controllers.dto;

import com.application.rest.SpringBootRestFootball.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDTO {

    private Long id;
    private String name;
    private List<Player> playerList = new ArrayList<>();
}
