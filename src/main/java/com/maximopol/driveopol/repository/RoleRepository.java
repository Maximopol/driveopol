package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.test.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}