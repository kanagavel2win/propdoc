package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propdoc.springboot.thymeleaf.entity.LoginRole;

@Repository
public interface LoginRoleRepository extends JpaRepository<LoginRole, Long> {
	LoginRole findByRole(String role);
}
