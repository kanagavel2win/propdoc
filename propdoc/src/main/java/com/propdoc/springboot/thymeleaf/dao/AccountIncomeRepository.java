package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.AccountsIncome;

public interface AccountIncomeRepository extends JpaRepository<AccountsIncome,Integer>{

	
}
