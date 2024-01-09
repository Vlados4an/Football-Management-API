package ru.erma.footballapiup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erma.footballapiup.model.Team;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    Optional<Team> findByName(String name);
}
