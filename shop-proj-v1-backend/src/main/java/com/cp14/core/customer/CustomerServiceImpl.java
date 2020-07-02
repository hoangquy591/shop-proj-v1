package com.cp14.core.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class CustomerServiceImpl extends AbstractService<Customer> implements ICustomerService {

	@Autowired ICustomerRepository repo;
	
	@Override
	protected JpaRepository<Customer, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
