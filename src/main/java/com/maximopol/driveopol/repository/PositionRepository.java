package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
