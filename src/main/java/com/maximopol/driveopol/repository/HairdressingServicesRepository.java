package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.HairdressingServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HairdressingServicesRepository extends JpaRepository<HairdressingServices, Long> {
    HairdressingServices findClientByName(String name);
}
