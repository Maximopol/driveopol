package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.test.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
//    private UserService userService;
    private ClientService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println(username + "==" + password);
        Client user = (Client) userService.loadUserByUsername(username);

        if (user != null && (user.getUsername().equals(username))) {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Wrong password");
            }



            if (user.getRoles() == null) {
                HashSet<Role> hashSet= new HashSet<>();
                hashSet.add(new Role(1L, "ROLE_ADMIN"));
                hashSet.add(new Role(2L, "ROLE_USER"));
                user.setRoles(hashSet);
              //  user.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));
            }
            for (Role r : user.getRoles()) {
                System.out.println(r.getName() + "====");
            }

            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

            System.out.println("Все норм");
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        } else
            throw new BadCredentialsException("Username not found");
    }

    public boolean supports(Class<?> arg) {
        return true;
    }
}