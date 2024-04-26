package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.ProjectMaster;

public interface ProjectMasterRepository extends JpaRepository<ProjectMaster,Integer>{

}
