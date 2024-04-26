package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.CheckOut;

public interface CheckOutRepository extends JpaRepository<CheckOut,Integer>{

}
