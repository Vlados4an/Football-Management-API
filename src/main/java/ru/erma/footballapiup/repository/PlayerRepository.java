package ru.erma.footballapiup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.erma.footballapiup.model.Player;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findByName(String name);
    @Query("SELECT p FROM Player p JOIN p.contract c WHERE EXTRACT(YEAR FROM c.until) = :currentYear")
    List<Player> findPlayersWithExpiredContracts(@Param("currentYear") int currentYear);
}
