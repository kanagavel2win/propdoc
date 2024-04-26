package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

}
