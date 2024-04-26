package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.AccountsIncome;

public interface AccountIncomeService {
	
	public AccountsIncome save(AccountsIncome obj);
	public List<AccountsIncome> saveall(List<AccountsIncome> obj);
	public AccountsIncome findById(Integer id);
	public List<AccountsIncome> findAll();
	
}
