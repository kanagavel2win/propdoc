package com.propdoc.springboot.thymeleaf.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.propdoc.springboot.thymeleaf.entity.Login;
import com.propdoc.springboot.thymeleaf.entity.LoginRegistrationDto;


public interface LoginService extends UserDetailsService {

    Login findByEmpid(String email);
    Login save(LoginRegistrationDto registration, String privilege);
    Login savePasswordchange(Login obj);
    Login resetall(LoginRegistrationDto obj, String privilege, long id);
   
	UserDetails loadUserByUsername(String empid) throws UsernameNotFoundException;
}