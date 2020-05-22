package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class AccountController {
    @Autowired
    private ClientService userService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String getMe(ModelMap model) {
        System.out.println("welcome to home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client user = (Client) userService.loadUserByUsername( auth.getName());

        model.put("name", user.getName());
        model.put("surname", user.getUsername());
        model.put("email", user.getEmail());

        Map<String, String> userMap = new HashMap<String, String>();

        int kek = new Random().nextInt(10);
        for(int i=0;i<kek;i++){
            userMap.put(i+"",i+"kjk");
        }
//        for (User user : users) {
//            userMap.put(user, calculateSililarity.calculate(sessionUser.getUserId(), user.getUserId()));
//        }

        model.addAttribute("userMap", userMap);
//        model.put("userss", new String[]{"Tom", "Bob", "Sam"});

        return "me";
    }
}
