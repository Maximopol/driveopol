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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/admin")
public class AdminController {
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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String showTodos(ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername(auth.getName());

        model.put("name", user.getName());
        model.put("surname", user.getSurname());
        model.put("email", user.getEmail());

        List<OrderS> list = orderService.getOrders();
        Map<Long, OrderS> orderMap = new HashMap<>();

        for (OrderS orderS : list) {
            orderS.setHairdressingServices(hairdressingServicesService.findServiceByID(orderS.getService()));
            Employees employees = employeesService.findEmployeesById(orderS.getMaster());
            employees.setMe(userService.findUserById(employees.getPerson()));
            orderS.setEmployees(employees);
            orderS.setOrderStatus(orderStatusService.findOrderStatusByID(new Integer(orderS.getStatus().toString())));
            orderS.setClientP(userService.findUserById(orderS.getClient()));
            orderMap.put(orderS.getId(), orderS);
        }
        model.addAttribute("orders", orderMap);

        return "admin/admin";
    }

    @GetMapping("/admin/dbtool")
    @PreAuthorize("hasRole('ADMIN')")
    public String showTodo(ModelMap model){
       // if(SecurityContextHolder.getContext().getAuthentication().getAuthorities())
       // SecurityContextHolderAwareRequestWrapper.isUserInRole("admin")
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        String password = (String) auth.getCredentials();
        System.out.println("Страницу ссhgghgмотрит долюою:"+username+"=="+password);
//        String name = (String) model.get("name");
//        model.put("todos", service.retrieveTodos(name));
        return "admin/dbtool";
    }
}
