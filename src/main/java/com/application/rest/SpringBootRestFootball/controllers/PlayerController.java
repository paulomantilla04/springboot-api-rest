package com.application.rest.SpringBootRestFootball.controllers;


import com.application.rest.SpringBootRestFootball.controllers.dto.PlayerDTO;
import com.application.rest.SpringBootRestFootball.entities.Player;
import com.application.rest.SpringBootRestFootball.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Player> playerOptional = playerService.findById(id);

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .id(player.getId())
                    .name(player.getName())
                    .age(player.getAge())
                    .number(player.getNumber())
                    .goals(player.getGoals())
                    .assists(player.getAssists())
                    .status(player.isStatus())
                    .club(player.getClub())
                    .build();

            return ResponseEntity.ok(playerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<PlayerDTO> playerList = playerService.findAll()
                .stream()
                .map(player -> PlayerDTO.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .age(player.getAge())
                        .number(player.getNumber())
                        .goals(player.getGoals())
                        .assists(player.getAssists())
                        .status(player.isStatus())
                        .club(player.getClub())
                        .build())
                .toList();

        return ResponseEntity.ok(playerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PlayerDTO playerDTO) throws URISyntaxException {
        if (playerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        playerService.save(Player.builder()
                .name(playerDTO.getName())
                .age(playerDTO.getAge())
                .number(playerDTO.getNumber())
                .goals(playerDTO.getGoals())
                .assists(playerDTO.getAssists())
                .status(playerDTO.isStatus())
                .club(playerDTO.getClub())
                .build());

        return ResponseEntity.created(new URI("/api/player/save")).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerService.findById(id);

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setName(playerDTO.getName());
            player.setAge(playerDTO.getAge());
            player.setNumber(playerDTO.getNumber());
            player.setGoals(playerDTO.getGoals());
            player.setAssists(playerDTO.getAssists());
            player.setStatus(playerDTO.isStatus());
            player.setClub(playerDTO.getClub());
            playerService.save(player);
            return ResponseEntity.ok("Jugador actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null) {
            playerService.deleteById(id);
            return ResponseEntity.ok("Jugador eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
