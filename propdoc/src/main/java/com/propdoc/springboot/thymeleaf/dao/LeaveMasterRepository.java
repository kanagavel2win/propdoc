package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.LeaveMaster;

public interface LeaveMasterRepository extends JpaRepository<LeaveMaster, Integer> {

	List<LeaveMaster> findByEmpid(Integer id);

}
