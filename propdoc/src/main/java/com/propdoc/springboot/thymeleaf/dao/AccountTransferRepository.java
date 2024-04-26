package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.AccountTransfer;

public interface AccountTransferRepository extends JpaRepository<AccountTransfer,Integer>{

	
}
