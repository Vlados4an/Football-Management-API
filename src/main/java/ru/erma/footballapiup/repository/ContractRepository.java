package ru.erma.footballapiup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.erma.footballapiup.model.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("SELECT c FROM Contract c WHERE EXTRACT(YEAR FROM c.until) = :currentYear")
    List<Contract> findContractsExpiringThisYear(@Param("currentYear") int currentYear);

}
