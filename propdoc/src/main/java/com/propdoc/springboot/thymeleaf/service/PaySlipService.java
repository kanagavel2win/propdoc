package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.payslip;


public interface PaySlipService  {

	public List<payslip> findByEmpid(String Employeeid);
	public List<payslip> findByPayperiod(String Payperiod);
	public List<payslip> findByPaymonth(String Payperiod);
	public void deleteByPayperiod(String Payperiod,String empid);
	public payslip save(payslip obj);
	public payslip findById(Integer id);
}