package com.cp14.core.catalog;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class CatalogServiceImpl extends AbstractService<Catalog> implements ICatalogService{

	@Autowired ICatalogRepository repo;
	
	@Override
	protected JpaRepository<Catalog, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
}
