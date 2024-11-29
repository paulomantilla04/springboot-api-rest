package com.application.rest.SpringBootRestFootball.repository;


import com.application.rest.SpringBootRestFootball.entities.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {
}
