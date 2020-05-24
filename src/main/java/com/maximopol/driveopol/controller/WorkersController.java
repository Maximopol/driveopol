package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.HairdressingServices;
import com.maximopol.driveopol.service.ClientService;
import com.maximopol.driveopol.service.EmployeesService;
import com.maximopol.driveopol.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/workers")
public class WorkersController {
    @Autowired
    EmployeesService employeesService;
    @Autowired
    PositionService positionService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String getWorkers(ModelMap model) {

        List<Employees> list = employeesService.allEmployees();
        Map<Long, Employees> employeesMap = new HashMap<>();

        for (Employees employees : list) {
            employees.setMe(clientService.findUserById(employees.getPerson()));
            employees.setPosition2(positionService.findPositionByID(employees.getPosition()));
            employeesMap.put(employees.getId(), employees);
            System.out.println(employees);
        }
        model.addAttribute("employees", employeesMap);
//        List<HairdressingServices> list = hairdressingServicesService.allServices();
//        Map<Long, HairdressingServices> userMap = new HashMap<Long, HairdressingServices>();
//
//        for (HairdressingServices hairdressingServices : list) {
//            userMap.put(hairdressingServices.getId(), hairdressingServices);
//        }
//
//        model.addAttribute("services", userMap);

        return "workers";
    }
}
