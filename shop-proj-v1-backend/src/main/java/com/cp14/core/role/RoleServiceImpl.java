package com.cp14.core.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class RoleServiceImpl extends AbstractService<Role> implements IRoleService {
	@Autowired IRoleRepository repo;
	
	@Override
	protected JpaRepository<Role, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
}
