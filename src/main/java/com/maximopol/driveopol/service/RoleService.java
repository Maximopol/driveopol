package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.Position;
import com.maximopol.driveopol.entity.test.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private ClientService userService;
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private PositionService positionService;

    private static final String ADMIN = "Администратор";

    public Set<Role> getRoles(String email) {
        HashSet<Role> hashSet = new HashSet<>();

        hashSet.add(new Role(1L, "ROLE_USER"));

        Client user = (Client) userService.loadUserByUsername(email);

        Employees employees = employeesService.findEmployeesByIDUser(user.getId());

        if (employees != null) {
            hashSet.add(new Role(2L, "ROLE_MASTER"));
            Position position = positionService.findPositionByID(employees.getPosition());

            if (position.getName().equals(ADMIN)) {
                hashSet.add(new Role(3L, "ROLE_ADMIN"));
            }
        }

        return hashSet;
    }
}
