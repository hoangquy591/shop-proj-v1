package com.cp14.core.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class AccountServiceImpl  extends AbstractService<Account> implements IAccountService{
	
	@Autowired IAccountRepository repo;

	@Override
	protected JpaRepository<Account, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
}
