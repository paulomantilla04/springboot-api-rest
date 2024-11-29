package com.application.rest.SpringBootRestFootball.persistence;

import com.application.rest.SpringBootRestFootball.entities.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerDAO {

    List <Player> findAll();

    Optional<Player> findById(Long id);

    List<Player> findByGoalsInRange(int min, int max);

    void save(Player player);

    void deleteById(Long id);
}
