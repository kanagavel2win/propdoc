package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.SnoMaster;

public interface SnoRepository extends JpaRepository<SnoMaster,Integer>{

	List<SnoMaster> findByCatogeryAndFinyear(String str,String finyear);

	
}
