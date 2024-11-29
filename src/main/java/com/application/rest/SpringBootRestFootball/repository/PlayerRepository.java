package com.application.rest.SpringBootRestFootball.repository;

import com.application.rest.SpringBootRestFootball.entities.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.goals BETWEEN ?1 AND ?2")
    List<Player> findPlayerByGoalsInRange(int min, int max);
}
