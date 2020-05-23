package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.HairdressingServices;
import com.maximopol.driveopol.service.HairdressingServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HairdressingServicesController {
    @Autowired
    HairdressingServicesService hairdressingServicesService;

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String getServices(ModelMap model) {

        List<HairdressingServices> list = hairdressingServicesService.allServices();
        Map<Long, HairdressingServices> userMap = new HashMap<Long, HairdressingServices>();

        for (HairdressingServices hairdressingServices : list) {
            userMap.put(hairdressingServices.getId(), hairdressingServices);
        }

        model.addAttribute("services", userMap);

        return "services";
    }
}