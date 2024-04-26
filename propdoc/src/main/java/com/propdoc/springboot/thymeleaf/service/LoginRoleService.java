package com.propdoc.springboot.thymeleaf.service;

import com.propdoc.springboot.thymeleaf.entity.LoginRole;


public interface LoginRoleService {

    LoginRole findByRole(String role);
   	
}
