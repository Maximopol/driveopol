package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Employees findClientByPerson(Long person);
}
