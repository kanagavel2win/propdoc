package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.EmployeeJobinfo;

public interface EmployeeJobinfoRepository extends JpaRepository<EmployeeJobinfo,Integer>{

	List<EmployeeJobinfo> findByEmployeeid(Integer id);

}
