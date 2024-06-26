package com.propdoc.springboot.thymeleaf.service;

import java.util.List;
import java.util.Map;

import com.propdoc.springboot.thymeleaf.entity.AttendanceMaster;

public interface AttendanceMasterService {

	public void save(AttendanceMaster obj);
	public AttendanceMaster findById(Integer id);
	public List<AttendanceMaster> findAll();
	public List<AttendanceMaster>  findByattendanceDate(String date);
	public List<Map<String, Object>> getpayrolldetails(String selectedmonth, String holidaysql, int branch_masterid);
	
	public List<Map<String, Object>> getatttendancereport(String monthstr, int prdenddate, int branchid);
	public void deleteById(int attendid);
}
