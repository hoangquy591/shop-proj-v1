package com.cp14.core.api.productdetail;

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
import com.cp14.core.productdetail.IProductDetailService;
import com.cp14.core.productdetail.ProductDetail;
import com.cp14.core.utils.ResponseMessage;


@RestController
@RequestMapping("/api/v1/productdetail")
public class ProductDetailAPI {
	@Autowired IProductDetailService productDetailService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public ResponseEntity<ProductDetail_getall_response> getAllAccount(HttpServletRequest request) {
		ProductDetail_getall_response response = new ProductDetail_getall_response();
		try {
			List<ProductDetail> data = productDetailService.findAll();
			
			response.data = data;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<ProductDetail_getall_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<ProductDetail_getall_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<ProductDetail_getById_response> getAccountById(HttpServletRequest request,
			@RequestBody ProductDetail_getById_request entity) {
		ProductDetail_getById_response response = new ProductDetail_getById_response();
		try {
			ProductDetail productDetail = productDetailService.findOne(entity.id);
			response.data = productDetail;
			
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<ProductDetail_getById_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<ProductDetail_getById_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<ProductDetail_create_response> create(@RequestBody ProductDetail_create_request entity, HttpServletRequest request ) { 
		ProductDetail_create_response response = new ProductDetail_create_response();
		try {
			ProductDetail productDetail = entity.data;
			
			productDetail = productDetailService.save(productDetail);
			response.id = productDetail.getId();
			response.productDetail = productDetail;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<ProductDetail_create_response>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
		    return new ResponseEntity<ProductDetail_create_response>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ResponseEntity<ResponseBase> delete(@RequestBody ProductDetail_delete_request entity, HttpServletRequest request ) { 
		ResponseBase response = new ResponseBase();
		try {
			productDetailService.deleteById(entity.id);
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
