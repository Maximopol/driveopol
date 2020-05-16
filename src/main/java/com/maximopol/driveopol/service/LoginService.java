package com.maximopol.driveopol.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
//public class LoginService {
//    public boolean validateUser(String userid, String password) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//       System.out.println("Дебил:"+auth.getName());
//       // SecurityContextHolder
//        // in28minutes, dummy
////        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
////
////        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
////
////        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
////            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
////            logger.debug(String.format("Auto login %s successfully!", username));
////        }
//
//
//
//        return userid.equalsIgnoreCase("in28minutes")
//                && password.equalsIgnoreCase("in28minutes");
//    }
//}
