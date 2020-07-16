package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.OrderS;
import com.maximopol.driveopol.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/master")
public class MasterController {
    @Autowired
    private ClientService userService;
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private HairdressingServicesService hairdressingServicesService;
    @Autowired
    PositionService positionService;
    @Autowired
    OrderStatusService orderStatusService;

    @RequestMapping(value = "/master", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MASTER')")
    public String getMe(ModelMap model) {
        System.out.println("welcome to home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        Client user = (Client) userService.loadUserByUsername(auth.getName());

        model.put("name", user.getName());
        model.put("surname", user.getSurname());
        model.put("email", user.getEmail());


        List<OrderS> list = orderService.getOrders();
        Map<Long, OrderS> orderMap = new HashMap<>(),
                orderMap2 = new HashMap<>();

        Employees employees = employeesService.findEmployeesByIDUser(user.getId());
        employees.setMe(userService.findUserById(employees.getPerson()));

        String stringNewStatusOrder = orderStatusService.findOrderStatusByID(1).getDescription();
        for (OrderS orderS : list) {
            if (orderS.getMaster().equals(employees.getId())) {
                orderS.setHairdressingServices(hairdressingServicesService.findServiceByID(orderS.getService()));
                orderS.setClientP(userService.findUserById(orderS.getClient()));
                orderS.setEmployees(employees);
                orderS.setOrderStatus(orderStatusService.findOrderStatusByID(new Integer(orderS.getStatus().toString())));
                //    orderS.setHairdressingServices(hairdressingServicesService.);
                orderMap.put(orderS.getId(), orderS);
                if (orderS.getOrderStatus().getDescription().equals(stringNewStatusOrder)) {
                    orderMap2.put(orderS.getId(), orderS);
                }
            }
        }
        model.addAttribute("orders", orderMap);
        model.addAttribute("ordersNew", orderMap2);


        return "master/master";
    }

    @RequestMapping(value = "/master", method = RequestMethod.POST, params = "takeOrder")
    public String takeOrder(HttpServletRequest req, HttpServletResponse res, ModelMap model) {

        OrderS orderS = orderService.findOrderByID(new Long(req.getParameterValues("servicesfF")[0]));
        orderS.setStatus(4L);

        orderService.updateOrder(orderS);
        System.out.println(orderS);
        System.out.println("takeOrder");
        return "master/master";
    }

    @RequestMapping(value = "/master", method = RequestMethod.POST, params = "cancelOrder")
    public String cancelOrder(HttpServletRequest req, HttpServletResponse res, ModelMap model) {
        OrderS orderS = orderService.findOrderByID(new Long(req.getParameterValues("servicesfF")[0]));
        orderS.setStatus(3L);

        orderService.updateOrder(orderS);
        System.out.println(orderS);
        System.out.println("cancelOrder");
        return "master/master";
    }
}
