package com.tatsam.assignment.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.assignment.entity.Priority;
import com.tatsam.assignment.entity.PriorityRequest;
import com.tatsam.assignment.service.Impl.PriorityServiceImpl;

/**
 * 
 * @author sohan
 * @implNote: Priority controller to handle Priority Entity related operation like: get, add etc.
 */

@RestController
@RequestMapping("/api/priority")
public class PriorityController {
	
	@Autowired
	private PriorityServiceImpl priorityServiceImpl;
	
	@GetMapping("/getAllPriority")
	public ResponseEntity getAllPriority(){
		List<Priority> list = priorityServiceImpl.getAllPriorityList();
		if(list==null || list.isEmpty())
			return new ResponseEntity("Data Not Found", HttpStatus.NO_CONTENT);
		
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/getPriority")
	@Procedure(name = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getPriority(Authentication auth){
		System.out.println(auth.getName());
		List<Priority> list = priorityServiceImpl.getPriorityListByUser(auth.getName());
		if(list==null || list.isEmpty())
			return new ResponseEntity("Data Not Found", HttpStatus.NO_CONTENT);
		
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/addPriority")
	public ResponseEntity addPriority(Authentication auth, @Valid @RequestBody PriorityRequest priorityRequest){
		String response = priorityServiceImpl.addPriorityWithSatification(auth.getName(),priorityRequest);
		if(response==null)
			return new ResponseEntity("Oops! something went wrong, please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity(response, HttpStatus.OK);
	}

}
