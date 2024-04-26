package com.propdoc.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.EmployeeJobempstatusRepository;
import com.propdoc.springboot.thymeleaf.entity.EmployeeJobempstatus;

@Service
public class EmployeeJobempstatusImp implements EmployeeJobempstatusService {

	@Autowired
	EmployeeJobempstatusRepository employeeRepo;
	
	@Override
	public EmployeeJobempstatus save(EmployeeJobempstatus obj) {
		return employeeRepo.save(obj);
	}

	@Override
	public EmployeeJobempstatus findById(Integer id) {
		Optional<EmployeeJobempstatus> obj=employeeRepo.findById(id);
		
		EmployeeJobempstatus bm=null;
		
		if(obj.isPresent())
		{	
			bm=obj.get();
		}else
		{
			throw new RuntimeException("Did find any records of Branch id "+ id);
		}
		return bm;
	}

	@Override
	public List<EmployeeJobempstatus> findAll() {
		
		return employeeRepo.findAll();
	}

	@Override
	public List<EmployeeJobempstatus> findByEmployeeid(Integer id) {
		return employeeRepo.findByEmployeeid(id);
	}

	@Override
	public void deleteById(int theId) {
		 employeeRepo.deleteById(theId);
		
	}
	
}