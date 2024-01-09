package ru.erma.footballapiup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.erma.footballapiup.model.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics,Long> {
}
