package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.OrderS;
import com.maximopol.driveopol.entity.Position;
import com.maximopol.driveopol.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public Position findPositionByID(Long ID) {
        Optional<Position> userFromDb = positionRepository.findById(ID);
        return userFromDb.orElse(new Position());
    }
}
