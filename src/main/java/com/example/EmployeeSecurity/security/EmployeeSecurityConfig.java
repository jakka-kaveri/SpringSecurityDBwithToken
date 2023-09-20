package com.example.EmployeeSecurity.security;

import com.example.EmployeeSecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private EmployeeRepository repository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/displayAll").permitAll()
                .antMatchers("/employeeInfo/**").authenticated()
                .antMatchers("/register").permitAll()
                 .and()
                .httpBasic();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("myaccount") // Replace with your user and password
//                .password("{noop}pwd") // Use {noop} for plain text password (not recommended for production)
//                .roles("USER");
//    }



}
