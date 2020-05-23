package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.test.Role;
import com.maximopol.driveopol.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;

    public Employees findEmployeesById(Long Id) {
        Optional<Employees> userFromDb = employeesRepository.findById(Id);
        return userFromDb.orElse(new Employees());
    }

    public Employees findEmployeesByIDUser(Long userId){
        return employeesRepository.findClientByPerson(userId);
    }

    public List<Employees> allEmployees() {
        return employeesRepository.findAll();
    }

}
