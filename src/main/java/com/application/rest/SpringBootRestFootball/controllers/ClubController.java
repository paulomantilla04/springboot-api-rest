package com.application.rest.SpringBootRestFootball.controllers;

import com.application.rest.SpringBootRestFootball.controllers.dto.ClubDTO;
import com.application.rest.SpringBootRestFootball.entities.Club;
import com.application.rest.SpringBootRestFootball.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/club")
public class ClubController {

    @Autowired
    private IClubService clubService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Club> clubOptional = clubService.findById(id);

        if(clubOptional.isPresent()){
            Club club = clubOptional.get();
            ClubDTO clubDTO = ClubDTO.builder()
                    .id(club.getId())
                    .name(club.getName())
                    .playerList(club.getPlayerList())
                    .build();

            return ResponseEntity.ok(clubDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ClubDTO> clubList = clubService.findAll()
                .stream()
                .map(club -> ClubDTO.builder()
                        .id(club.getId())
                        .name(club.getName())
                        .playerList(club.getPlayerList())
                        .build())
                .toList();

        return ResponseEntity.ok(clubList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClubDTO clubDTO) throws URISyntaxException {
        if (clubDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        clubService.save(Club.builder()
                .name(clubDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/club/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClub(@PathVariable Long id, @RequestBody ClubDTO clubDTO) {
        Optional <Club> clubOptional = clubService.findById(id);

        if(clubOptional.isPresent()){
            Club club = clubOptional.get();
            club.setName(clubDTO.getName());
            clubService.save(club);
            return ResponseEntity.ok("Club actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null) {
            clubService.deleteById(id);
            return ResponseEntity.ok("Club eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
