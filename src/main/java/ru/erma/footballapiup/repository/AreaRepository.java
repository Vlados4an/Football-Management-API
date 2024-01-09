package ru.erma.footballapiup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erma.footballapiup.model.Area;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area,Long> {
    Optional<Area> findByName(String name);
}
