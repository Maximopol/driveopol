package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Employees;
import com.maximopol.driveopol.entity.OrderS;
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

@Controller("/newlogin")
public class Login2Controller {
    @RequestMapping(value = "/newlogin", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('MASTER')")
    public String getMe(ModelMap model) {
        System.out.println("welcome to home");


        return "public/login2";
    }
}
