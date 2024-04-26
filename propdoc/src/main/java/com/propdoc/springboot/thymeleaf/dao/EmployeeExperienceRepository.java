package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.BranchMaster;
import com.propdoc.springboot.thymeleaf.entity.EmployeeExperience;

public interface EmployeeExperienceRepository extends JpaRepository<EmployeeExperience,Integer>{

}
