package com.tatsam.assignment.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.assignment.entity.User;
import com.tatsam.assignment.service.Impl.UserServiceImpl;

/**
 * 
 * @author sohan
 * @implNote: user controller to handle user Entity related operation like: add, delete, get etc.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/addUser")
	@Procedure(name = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		String response = userServiceImpl.addUser(user);
		if(response==null)
			return new ResponseEntity<String>("Oops! something went wrong, please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
