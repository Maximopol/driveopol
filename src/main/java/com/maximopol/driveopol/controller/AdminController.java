package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping("/admin")
     @PreAuthorize("hasRole('ADMIN')")
    public String showTodos(ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        String password = (String) auth.getCredentials();
        System.out.println("Страницу ссмотрит долюою:"+username+"=="+password);
//        String name = (String) model.get("name");
//        model.put("todos", service.retrieveTodos(name));
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
