package com.propdoc.springboot.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.LoginRoleRepository;
import com.propdoc.springboot.thymeleaf.entity.LoginRole;

@Service
public class LoginRoleServiceImpl implements LoginRoleService {

    @Autowired
    private LoginRoleRepository userRoleRepository;

	
	@Override
	public LoginRole findByRole(String role) {
		return userRoleRepository.findByRole(role);
	}

	
		
}
