package com.cp14.core.api.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp14.core.base.ResponseBase;
import com.cp14.core.product.IProductService;
import com.cp14.core.product.Product;
import com.cp14.core.utils.ResponseMessage;

@RestController
@RequestMapping("/api/v1/product")
public class ProductAPI {
	@Autowired IProductService productService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public ResponseEntity<Product_getall_response> getAllAccount(HttpServletRequest request) {
		Product_getall_response response = new Product_getall_response();
		try {
			List<Product> data = productService.findAll();
			
			response.data = data;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Product_getall_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<Product_getall_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<Product_getById_response> getAccountById(HttpServletRequest request,
			@RequestBody Product_getById_request entity) {
		Product_getById_response response = new Product_getById_response();
		try {
			Product product = productService.findOne(entity.id);
			response.data = product;
			
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Product_getById_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<Product_getById_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<Product_create_response> create(@RequestBody Product_create_request entity, HttpServletRequest request ) { 
		Product_create_response response = new Product_create_response();
		try {
			Product product = entity.data;
			
			product = productService.save(product);
			response.id = product.getId();
			response.product = product;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Product_create_response>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
		    return new ResponseEntity<Product_create_response>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ResponseEntity<ResponseBase> delete(@RequestBody Product_delete_request entity, HttpServletRequest request ) { 
		ResponseBase response = new ResponseBase();
		try {
			productService.deleteById(entity.id);
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<ResponseBase>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
		    return new ResponseEntity<ResponseBase>(response,HttpStatus.BAD_REQUEST);
		}
	}
}
