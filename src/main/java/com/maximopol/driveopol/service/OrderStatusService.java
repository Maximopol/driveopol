package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.OrderStatus;
import com.maximopol.driveopol.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public OrderStatus findOrderStatusByID(Integer id) {
        Optional<OrderStatus> userFromDb = orderStatusRepository.findById(id);
        return userFromDb.orElse(new OrderStatus());
    }
}
