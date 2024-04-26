package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.EmployeeJobHire;
import com.propdoc.springboot.thymeleaf.entity.EmployeeJobempstatus;

public interface EmployeeJobHireService {
	
	public EmployeeJobHire save(EmployeeJobHire obj);
	public EmployeeJobHire findById(Integer id);
	public List<EmployeeJobHire> findAll();
	public List<EmployeeJobHire> findByEmployeeid(Integer id);
	
}
