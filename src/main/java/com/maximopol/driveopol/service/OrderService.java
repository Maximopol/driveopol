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
        return orderRepository.findByMaster(masterID);
//        Optional<OrderS> userFromDb = orderRepository.findById(masterID);
//        return userFromDb.orElse(new OrderS());
    }

    public OrderS findOrderByClient(Long clientrID) {
        return orderRepository.findByClient(clientrID);
//        Optional<OrderS> userFromDb = orderRepository.findById(clientrID);
//        return userFromDb.orElse(new OrderS());
    }

    public OrderS findOrderByID(Long ID) {
        Optional<OrderS> userFromDb = orderRepository.findById(ID);
        return userFromDb.orElse(new OrderS());
    }

    public List<OrderS> getOrders() {
        return orderRepository.findAll();
    }

    public void updateOrder(OrderS orderS) {
        orderRepository.save(orderS);
    }

    public boolean saveOrder(OrderS orderS) {

        if (orderS.getId() != null) {
            Optional<OrderS> orderS1 = orderRepository.findById(orderS.getId());

            if (orderS1.isPresent()) {
                return false;
            }
        }

//        OrderS orderSFromDB = orderRepository.(orderS.getClient());
//
//        if (orderSFromDB != null) {
//            return false;
//        }
        orderRepository.save(orderS);
        return true;
    }

    public boolean deleteOrder(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}
