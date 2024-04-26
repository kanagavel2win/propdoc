package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.AccountTransfer;

public interface AccountTransferService {
	
	public AccountTransfer save(AccountTransfer obj);
	public List<AccountTransfer> saveall(List<AccountTransfer> obj);
	public AccountTransfer findById(Integer id);
	public List<AccountTransfer> findAll();
	
}
