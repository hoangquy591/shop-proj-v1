package com.cp14.core.productdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cp14.core.base.AbstractService;

@Service
public class ProductDetailServiceImpl extends AbstractService<ProductDetail> implements IProductDetailService{

	@Autowired IProductDetailRepository repo;
	
	@Override
	protected JpaRepository<ProductDetail, Long> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
