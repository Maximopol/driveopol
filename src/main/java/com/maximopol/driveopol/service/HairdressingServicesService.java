package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
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

@Service
public class HairdressingServicesService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    HairdressingServicesRepository hairdressingServicesRepository;

    public List<HairdressingServices> allServices() {
        return hairdressingServicesRepository.findAll();
    }
}
