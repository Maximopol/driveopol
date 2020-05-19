package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByEmail(String email);
//    Client findByUsername(String email);
//    @Query("SELECT v FROM Client v WHERE v.visitType='NEW'")
//    List<Client> findByVisitType();
}
