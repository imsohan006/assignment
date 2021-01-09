package com.tatsam.assignment.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.assignment.entity.Areas;
import com.tatsam.assignment.service.Impl.AreaServiceImpl;

/**
 * 
 * @author sohan
 * @implNote: Area controller to handle Area Entity related operation
 */


@RestController
@RequestMapping("/api/area")
public class AreaController {
	
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	
	@PostMapping("/addArea")
	public ResponseEntity<String> addArea(@Valid @RequestBody Areas area) {
		String response = areaServiceImpl.addArea(area);
		if(response==null)
			return new ResponseEntity<String>("Oops! something went wrong, please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
