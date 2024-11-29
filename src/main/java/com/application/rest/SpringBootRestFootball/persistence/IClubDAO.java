package com.application.rest.SpringBootRestFootball.persistence;

import com.application.rest.SpringBootRestFootball.entities.Club;

import java.util.List;
import java.util.Optional;

public interface IClubDAO {

    List <Club> findAll();

    Optional<Club> findById(Long id);

    void save(Club club);

    void deleteById(Long id);
}
