package com.cp14.core.api.role;

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
import com.cp14.core.role.IRoleService;
import com.cp14.core.role.Role;

@RestController
@RequestMapping("/api/v1/role")
public class RoleAPI {
	@Autowired IRoleService roleService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public ResponseEntity<Role_getall_response> getAllRole(HttpServletRequest request) {
		Role_getall_response response = new Role_getall_response();
		try {
			List<Role> data = roleService.findAll();
			
			response.data = data;
			response.setMessage("It's all OK");
			return new ResponseEntity<Role_getall_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<Role_getall_response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<Role_getById_response> getRoleById(HttpServletRequest request,
			@RequestBody Role_getById_request entity) {
		Role_getById_response response = new Role_getById_response();
		try {
			Role role = roleService.findOne(entity.id);
			response.data = role;
			
			response.setMessage("It's all OK");
			return new ResponseEntity<Role_getById_response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<Role_getById_response>(response, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<Role_create_response> create(@RequestBody Role_create_request entity, HttpServletRequest request ) { 
		Role_create_response response = new Role_create_response();
		try {
			Role role = entity.data;
			role = roleService.save(role);
			response.id = role.getId();
			response.role = role;
			response.setMessage("It's all OK");
			return new ResponseEntity<Role_create_response>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setMessage(e.getMessage());
		    return new ResponseEntity<Role_create_response>(response,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ResponseEntity<ResponseBase> delete(@RequestBody Role_delete_request entity, HttpServletRequest request ) { 
		ResponseBase response = new ResponseBase();
		try {
			roleService.deleteById(entity.id);
			response.setMessage("It's all OK");
			return new ResponseEntity<ResponseBase>(response,HttpStatus.OK);
		}catch (Exception e) {
			response.setMessage(e.getMessage());
		    return new ResponseEntity<ResponseBase>(response,HttpStatus.OK);
		}
	}
}
