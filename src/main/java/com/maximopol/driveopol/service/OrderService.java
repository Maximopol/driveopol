package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.OrderS;
import com.maximopol.driveopol.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public OrderS findOrderByMaster(Long masterID) {
        Optional<OrderS> userFromDb = orderRepository.findById(masterID);
        return userFromDb.orElse(new OrderS());
    }

    public OrderS findOrderByClient(Long clientrID) {
        Optional<OrderS> userFromDb = orderRepository.findById(clientrID);
        return userFromDb.orElse(new OrderS());
    }

    public List<OrderS> getOrders() {
        return orderRepository.findAll();
    }

    public boolean saveOrder(OrderS orderS) {
        OrderS orderSFromDB = orderRepository.findByClient(orderS.getClient());

        if (orderSFromDB != null) {
            return false;
        }
        orderRepository.save(orderS);
        return true;
    }
}
