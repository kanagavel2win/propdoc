package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.HireMaster;

public interface HireMasterRepository extends JpaRepository<HireMaster, Integer> {

}
