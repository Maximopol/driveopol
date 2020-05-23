package com.maximopol.driveopol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/workers")
public class WorkersController {
    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String getWorkers(ModelMap model) {


    return "workers";
    }
}
