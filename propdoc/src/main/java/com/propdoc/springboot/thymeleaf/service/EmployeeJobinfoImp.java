package com.propdoc.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.EmployeeJobinfoRepository;
import com.propdoc.springboot.thymeleaf.entity.EmployeeJobinfo;

@Service
public class EmployeeJobinfoImp implements EmployeeJobinfoService {

	@Autowired
	EmployeeJobinfoRepository employeeRepo;
	
	@Override
	public EmployeeJobinfo save(EmployeeJobinfo obj) {
		return employeeRepo.save(obj);
	}

	@Override
	public EmployeeJobinfo findById(Integer id) {
		Optional<EmployeeJobinfo> obj=employeeRepo.findById(id);
		
		EmployeeJobinfo bm=null;
		
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
	public List<EmployeeJobinfo> findAll() {
		
		return employeeRepo.findAll();
	}

	@Override
	public List<EmployeeJobinfo> findByEmployeeid(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepo.findByEmployeeid(id);
	}

	@Override
	public void deleteById(int theId) {
		 employeeRepo.deleteById(theId);
		
	}

	
	
}
