package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.BranchMaster;
import com.propdoc.springboot.thymeleaf.entity.EmployeeEducation;

public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation,Integer>{

}
