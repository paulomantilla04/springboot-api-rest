package com.application.rest.SpringBootRestFootball.persistence.impl;

import com.application.rest.SpringBootRestFootball.entities.Club;
import com.application.rest.SpringBootRestFootball.persistence.IClubDAO;
import com.application.rest.SpringBootRestFootball.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClubDAOImpl implements IClubDAO {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<Club> findAll() {
        return (List<Club>) clubRepository.findAll();
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public void save(Club club) {
        clubRepository.save(club);
    }

    @Override
    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }
}
