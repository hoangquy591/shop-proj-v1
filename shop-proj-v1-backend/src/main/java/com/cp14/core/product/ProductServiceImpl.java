package com.cp14.core.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class ProductServiceImpl extends AbstractService<Product> implements IProductService{

	@Autowired IProductRepository repo;
	
	@Override
	protected JpaRepository<Product, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
