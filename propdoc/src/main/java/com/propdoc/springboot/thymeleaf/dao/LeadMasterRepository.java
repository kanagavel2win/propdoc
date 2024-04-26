package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.LeadMaster;

public interface LeadMasterRepository extends JpaRepository<LeadMaster,Integer>{

}
