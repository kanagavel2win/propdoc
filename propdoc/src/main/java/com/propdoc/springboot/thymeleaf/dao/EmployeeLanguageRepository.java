package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.BranchMaster;
import com.propdoc.springboot.thymeleaf.entity.EmployeeFiles;
import com.propdoc.springboot.thymeleaf.entity.EmployeeLanguage;

public interface EmployeeLanguageRepository extends JpaRepository<EmployeeLanguage,Integer>{

}
