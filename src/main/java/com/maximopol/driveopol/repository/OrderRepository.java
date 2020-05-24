package com.maximopol.driveopol.repository;

import com.maximopol.driveopol.entity.OrderS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderS, Long> {
    OrderS findByMaster(Long master);

    OrderS findByClient(Long client);
}
