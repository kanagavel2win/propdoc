package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.EmployeeJobcompensation;

public interface EmployeeJobcompensationRepository extends JpaRepository<EmployeeJobcompensation,Integer>{

	List<EmployeeJobcompensation> findByEmployeeid(Integer id);

}
