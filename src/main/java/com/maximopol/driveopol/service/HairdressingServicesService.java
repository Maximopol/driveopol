package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.HairdressingServices;
import com.maximopol.driveopol.repository.ClientRepository;
import com.maximopol.driveopol.repository.HairdressingServicesRepository;
import com.maximopol.driveopol.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class HairdressingServicesService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    HairdressingServicesRepository hairdressingServicesRepository;

    public List<HairdressingServices> allServices() {
        return hairdressingServicesRepository.findAll();
    }

    public HairdressingServices findEmployeesByName(String name) {
        return hairdressingServicesRepository.findClientByName(name);
    }

    public HairdressingServices findServiceByID(Long id) {
        Optional<HairdressingServices> userFromDb = hairdressingServicesRepository.findById(id);
        return userFromDb.orElse(new HairdressingServices());
    }
}
