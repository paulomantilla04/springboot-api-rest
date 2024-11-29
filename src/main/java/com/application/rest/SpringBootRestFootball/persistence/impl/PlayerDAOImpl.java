package com.application.rest.SpringBootRestFootball.persistence.impl;

import com.application.rest.SpringBootRestFootball.entities.Player;
import com.application.rest.SpringBootRestFootball.persistence.IPlayerDAO;
import com.application.rest.SpringBootRestFootball.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerDAOImpl implements IPlayerDAO {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findByGoalsInRange(int min, int max) {
        return playerRepository.findPlayerByGoalsInRange(min, max);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
