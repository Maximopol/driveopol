package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.test.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}