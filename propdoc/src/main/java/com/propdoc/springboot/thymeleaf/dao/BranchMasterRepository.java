package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.BranchMaster;

public interface BranchMasterRepository extends JpaRepository<BranchMaster,Integer>{

	
}
