package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.EmployeeJobempstatus;

public interface EmployeeJobempstatusRepository extends JpaRepository<EmployeeJobempstatus,Integer>{

	List<EmployeeJobempstatus> findByEmployeeid(Integer id);

}
