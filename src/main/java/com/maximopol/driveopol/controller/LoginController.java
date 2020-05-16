package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.service.AuthProvider;
//import com.maximopol.driveopol.service.LoginService;
import com.maximopol.driveopol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

//@Controller
//@SessionAttributes("name")
//public class LoginController {
//    @Autowired
//    LoginService service;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private AuthProvider authProvider;
//
//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String showLoginPage(ModelMap model){
//        System.out.println("rewrwerwer");
//        return "login";
//    }
//
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String showWelcomePage(HttpServletRequest request,ModelMap model, @RequestParam String name, @RequestParam String password){
//        System.out.println("hjhjkjjjjjjjjjjjjjjjjjjjj");
//
//        System.out.println(name+":"+password);
//
//        if (!service.validateUser(name, password)) {
//            model.put("errorMessage", "Invalid Credentials");
//            return "login";
//        }
//      //  authProvider.authenticate();
////        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(name, password);
////        authToken.setDetails(new WebAuthenticationDetails(request));
////
////        Authentication authentication = authenticationManager.authenticate(authToken);
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
////        model.put("name", name);
////        model.put("password", password);
////
////        userService.loadUserByUsername(name);
//
//        return "welcome";
//    }
//}
