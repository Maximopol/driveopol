package com.maximopol.driveopol.config;


import com.maximopol.driveopol.service.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthProvider authProvider;

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/admin", "/dbtool").access("hasRole('ADMIN')")
                .antMatchers("/disk", "/me", "/list-todos", "/welcome").access("hasRole('USER')")
                .antMatchers("/", "/login", "/register").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error")
                .and()
                .formLogin()
                .loginPage("/login")
             //   .loginProcessingUrl("/submit")
                .defaultSuccessUrl("/admin")
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("pass")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
    {
        auth.authenticationProvider(authProvider);
    }

    /**
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
