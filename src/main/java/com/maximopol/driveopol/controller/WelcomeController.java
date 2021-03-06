package com.maximopol.driveopol.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller("/welcome")
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String showLoginPage(ModelMap model) {
        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String showWelcome(ModelMap model) {
        return "welcome";
    }
}
