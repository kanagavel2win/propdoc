package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.DealMaster;

public interface DealMasterRepository extends JpaRepository<DealMaster,Integer>{

}
