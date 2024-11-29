package com.application.rest.SpringBootRestFootball.service.impl;

import com.application.rest.SpringBootRestFootball.entities.Player;
import com.application.rest.SpringBootRestFootball.persistence.IPlayerDAO;
import com.application.rest.SpringBootRestFootball.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private IPlayerDAO playerDAO;

    @Override
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerDAO.findById(id);
    }

    @Override
    public List<Player> findByGoalsInRange(int min, int max) {
        return playerDAO.findByGoalsInRange(min, max);
    }

    @Override
    public void save(Player player) {
        playerDAO.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerDAO.deleteById(id);
    }
}
