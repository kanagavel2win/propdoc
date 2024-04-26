package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.CheckInFiles;

public interface CheckInFilesRepository extends JpaRepository<CheckInFiles,Integer>{

}
