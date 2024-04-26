package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.SnoMaster;

public interface SnoService {
	
	public SnoMaster save(SnoMaster obj);
	public SnoMaster findById(Integer id);
	public List<SnoMaster> findAll();
	public List<SnoMaster> findByCatogeryAndFinyear(String c,String finYear);
	
}
