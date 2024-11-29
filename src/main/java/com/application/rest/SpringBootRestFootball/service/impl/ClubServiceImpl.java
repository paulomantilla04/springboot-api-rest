package com.application.rest.SpringBootRestFootball.service.impl;

import com.application.rest.SpringBootRestFootball.entities.Club;
import com.application.rest.SpringBootRestFootball.persistence.IClubDAO;
import com.application.rest.SpringBootRestFootball.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements IClubService {

    @Autowired
    private IClubDAO clubDAO;

    @Override
    public List<Club> findAll() {
        return clubDAO.findAll();
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubDAO.findById(id);
    }

    @Override
    public void save(Club club) {
        clubDAO.save(club);
    }

    @Override
    public void deleteById(Long id) {
        clubDAO.deleteById(id);
    }
}
