package com.cp14.core.api.catalog;

import java.util.Date;
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
import com.cp14.core.catalog.Catalog;
import com.cp14.core.catalog.ICatalogService;
import com.cp14.core.utils.ResponseMessage;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogAPI {

	@Autowired ICatalogService catalogService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public ResponseEntity<Catalog_getall_response> getAll(HttpServletRequest request) {
		Catalog_getall_response response = new Catalog_getall_response();
		try {
			List<Catalog> data = catalogService.findAll();
			response.data = data;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Catalog_getall_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<Catalog_getall_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<Catalog_getById_response> getById(HttpServletRequest request,
			@RequestBody Catalog_getById_request entity) {
		Catalog_getById_response response = new Catalog_getById_response();
		try {
			Catalog catalog = catalogService.findOne(entity.id);
			response.data = catalog;
			
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Catalog_getById_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
			return new ResponseEntity<Catalog_getById_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<Catalog_create_response> create(@RequestBody Catalog_create_request entity, HttpServletRequest request ) { 
		Catalog_create_response response = new Catalog_create_response();
		try {
			Catalog catalog = entity.data;
			
			catalog = catalogService.save(catalog);
			response.id = catalog.getId();
			response.catalog = catalog;
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<Catalog_create_response>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(e.getMessage());
		    return new ResponseEntity<Catalog_create_response>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ResponseEntity<ResponseBase> delete(@RequestBody Catalog_delete_request entity, HttpServletRequest request ) { 
		ResponseBase response = new ResponseBase();
		try {
			catalogService.deleteById(entity.id);
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
