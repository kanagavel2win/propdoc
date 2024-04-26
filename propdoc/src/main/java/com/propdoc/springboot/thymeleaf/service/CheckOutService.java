package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.CheckOut;

public interface CheckOutService {
	
	public CheckOut save(CheckOut obj);
	public CheckOut findById(Integer id);
	public List<CheckOut> findAll();
	public List<CheckOut> saveall(List<CheckOut> listcheckout);
	
}
