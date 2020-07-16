package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@Component
public class AuthProvider implements AuthenticationProvider {
    private static Logger logger = LogManager.getLogger(AuthProvider.class);
    @Autowired
    private ClientService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        logger.info("Logged in user with mail:" + username);

        Client user = (Client) userService.loadUserByUsername(username);

        if (user != null && (user.getUsername().equals(username))) {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                logger.info("This user entered the wrong password!");
                throw new BadCredentialsException("Wrong password");
            }

            user.setRoles(roleService.getRoles(username));

//                //  user.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));

            for (Role r : user.getRoles()) {
                logger.info("This user has a role as " + r.getName());
            }

            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

            logger.info("User logged in");
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        } else {
            logger.info("User not found");
            throw new BadCredentialsException("Username not found");
        }
    }

    public boolean supports(Class<?> arg) {
        return true;
    }
}