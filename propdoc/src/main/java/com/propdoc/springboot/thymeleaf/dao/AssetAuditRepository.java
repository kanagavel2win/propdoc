package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.AssetAudit;

public interface AssetAuditRepository extends JpaRepository<AssetAudit,Integer>{

}