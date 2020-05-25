package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.HairdressingServices;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("/account")
public class AccountController {
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

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String getMe(ModelMap model) {
        System.out.println("welcome to home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername(auth.getName());

        List<OrderS> list = orderService.getOrders();

        Map<Long, OrderS> orderMap = new HashMap<Long, OrderS>(),
                orderMap2 = new HashMap<Long, OrderS>();

        for (OrderS orderS : list) {
            if (orderS.getClient().equals(user.getId())) {
                orderS.setHairdressingServices(hairdressingServicesService.findServiceByID(orderS.getService()));
                Employees employees = employeesService.findEmployeesById(orderS.getMaster());
                employees.setMe(userService.findUserById(employees.getPerson()));
                orderS.setEmployees(employees);
                orderS.setOrderStatus(orderStatusService.findOrderStatusByID(new Integer(orderS.getStatus().toString())));
                //    orderS.setHairdressingServices(hairdressingServicesService.);
                orderMap.put(orderS.getId(), orderS);
                if (orderS.getStatus().equals(1L)) {
                    orderMap2.put(orderS.getId(), orderS);
                }
            }
        }
        model.addAttribute("orders", orderMap);
        model.addAttribute("orders2", orderMap2);

        model.put("name", user.getName());
        model.put("surname", user.getSurname());
        model.put("email", user.getEmail());

        List<Employees> employeesList = employeesService.allEmployees();

        List<HairdressingServices> hairdressingServicesList = hairdressingServicesService.allServices();

        Map<Long, Employees> employeesMap = new HashMap<>();
        Map<Long, HairdressingServices> hairdressingServicesMap = new HashMap<>();

        for (Employees employees : employeesList) {
            employees.setMe(userService.findUserById(employees.getPerson()));
            employees.setPosition2(positionService.findPositionByID(employees.getPosition()));

            employeesMap.put(employees.getId(), employees);
        }
        model.addAttribute("workers", employeesMap);

        for (HairdressingServices hairdressingServices : hairdressingServicesList) {
            hairdressingServicesMap.put(hairdressingServices.getId(), hairdressingServices);

        }
        model.addAttribute("services", hairdressingServicesMap);
        model.addAttribute("Order", new OrderS());
        return "me";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, params = "createOrder")
    public String createOrder(HttpServletRequest req, HttpServletResponse res, ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername(auth.getName());

        System.out.println(Arrays.toString(req.getParameterValues("calendar")));
        System.out.println(Arrays.toString(req.getParameterValues("services")));
        System.out.println(Arrays.toString(req.getParameterValues("workers")));


        OrderS orderS = new OrderS();

        orderS.setClient(user.getId());
        orderS.setService(hairdressingServicesService.findEmployeesByName(req.getParameterValues("services")[0]).getId());

        String[] strings = req.getParameterValues("workers")[0].split(" ");

        Client client = userService.findClientByNameAndSurname(strings[1], strings[0]);

        Employees employees = employeesService.findEmployeesByIDUser(client.getId());

        orderS.setMaster(employees.getId());

//orderS.setMaster();
        orderS.setStatus(1L);
        orderS.setDataCompletion(req.getParameterValues("calendar")[0]);


        orderS.setDataCreated(new SimpleDateFormat("d-MM-yyyy").format(new GregorianCalendar().getTime()));
        System.out.println(orderS);

        orderService.saveOrder(orderS);
        System.out.println("createOrder");
        return "me";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, params = "changeOrder")
    public String changeOrder(HttpServletRequest req, HttpServletResponse res, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername(auth.getName());

        OrderS orderS = new OrderS();

        orderS.setClient(user.getId());
        orderS.setService(hairdressingServicesService.findEmployeesByName(req.getParameterValues("servicesNew")[0]).getId());

        String[] strings = req.getParameterValues("workersNew")[0].split(" ");

        Client client = userService.findClientByNameAndSurname(strings[1], strings[0]);

        Employees employees = employeesService.findEmployeesByIDUser(client.getId());

        orderS.setMaster(employees.getId());

//orderS.setMaster();
        orderS.setStatus(1L);
        orderS.setDataCompletion(req.getParameterValues("calendarNew")[0]);


        orderS.setDataCreated(new SimpleDateFormat("d-MM-yyyy").format(new GregorianCalendar().getTime()));
        System.out.println(orderS);

        orderS.setId(new Long(req.getParameterValues("ordersForС")[0]));


        orderService.updateOrder(orderS);

        System.out.println("changeOrder");
        return "me";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, params = "deleteOrder")
    public String deleteOrder(HttpServletRequest req, HttpServletResponse res, ModelMap model) {

        OrderS orderS = orderService.findOrderByID(new Long(req.getParameterValues("ordersForDel")[0]));
        orderS.setStatus(2L);

        orderService.updateOrder(orderS);
        System.out.println(orderS);
//        System.out.println("cancelOrder");
//
//        System.out.println(Arrays.toString(req.getParameterValues("ordersForDel")));
//        orderService.deleteOrder(new Long(req.getParameterValues("ordersForDel")[0]));
        System.out.println("cancelOrder");
        return "me";
    }
}