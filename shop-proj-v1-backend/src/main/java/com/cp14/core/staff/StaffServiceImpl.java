package com.cp14.core.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class StaffServiceImpl extends AbstractService<Staff> implements IStaffService{

	@Autowired IStaffRepository repo;
	
	@Override
	protected JpaRepository<Staff, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
