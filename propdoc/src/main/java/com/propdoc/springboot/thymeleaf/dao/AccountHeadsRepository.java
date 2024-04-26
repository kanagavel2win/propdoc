package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.Accountsheads;

public interface AccountHeadsRepository extends JpaRepository<Accountsheads,Integer>{

}
