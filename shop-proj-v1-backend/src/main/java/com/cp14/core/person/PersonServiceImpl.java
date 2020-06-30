package com.cp14.core.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class PersonServiceImpl extends AbstractService<Person> implements IPersonService{

	@Autowired IPersonRepository repo;

	@Override
	protected JpaRepository<Person, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
}
