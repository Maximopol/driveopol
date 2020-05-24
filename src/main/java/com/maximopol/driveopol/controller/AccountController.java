package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.OrderS;
import com.maximopol.driveopol.service.ClientService;
import com.maximopol.driveopol.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller("/account")
public class AccountController {
    @Autowired
    private ClientService userService;

    //    @Autowired
//    private EmployeesService employeesService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String getMe(ModelMap model) {
        System.out.println("welcome to home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername(auth.getName());

        List<OrderS> list = orderService.getOrders();

        Map<Long, OrderS> orderMap = new HashMap<Long, OrderS>();

        for (OrderS orderS : list) {
            if (orderS.getClient().equals(user.getId())) {
                orderMap.put(orderS.getId(), orderS);
            }
        }
        model.addAttribute("orders", orderMap);
//        Employees employees= employeesService.findEmployeesByIDUser(user.getId());
//
//        System.out.println(employees);
//
//
//        Client user2= (Client)userService.loadUserByUsername("maximopolnate@gmail.com");
//        System.out.println(user2);
//
//        Employees employees2= employeesService.findEmployeesByIDUser(user2.getId());
//
//        System.out.println(employees2);


        model.put("name", user.getName());
        model.put("surname", user.getUsername());
        model.put("email", user.getEmail());



//        model.put("userss", new String[]{"Tom", "Bob", "Sam"});

        return "me";
    }

//    @RequestMapping(params = "buttonCreateOrder", method = RequestMethod.POST)
//    public void actionRu(//@ModelAttribute Greeting greeting,
//                         ModelMap model) {
//        System.out.println("На меня нажали");
//    }
}