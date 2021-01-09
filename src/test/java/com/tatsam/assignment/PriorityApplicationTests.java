package com.tatsam.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tatsam.assignment.entity.Areas;
import com.tatsam.assignment.entity.PriorityRequest;
import com.tatsam.assignment.entity.Role;
import com.tatsam.assignment.entity.User;
import com.tatsam.assignment.service.Impl.AreaServiceImpl;
import com.tatsam.assignment.service.Impl.PriorityServiceImpl;
import com.tatsam.assignment.service.Impl.UserServiceImpl;

/**
 * 
 * @author Sohan Yadav
 * @implNote: simple test cases with JUnit
 */
@SpringBootTest
class PriorityApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private PriorityServiceImpl priorityServiceImpl;
	
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@Test
	public void saveArea() {
		Areas areas = new Areas(new Random().toString());
		String response  = areaServiceImpl.addArea(areas);
		assertNotEquals(null, response);
	}
	
	@Test
	public void saveArea_With_Dublicate() {
		Areas areas = new Areas("Connection");
		assertEquals("area already exist", areaServiceImpl.addArea(areas));
	}
	
	@Test
	public void savePriority() {
		PriorityRequest priorityRequest = new PriorityRequest("Connection", 1, 1);
		String response  = priorityServiceImpl.addPriorityWithSatification("admin", priorityRequest);
		assertEquals("Created", response);
	}
	
	@Test
	public void savePriority_with_Wrong_Area() {
		PriorityRequest priorityRequest = new PriorityRequest("XXX", 1, 2);
		String response  = priorityServiceImpl.addPriorityWithSatification("admin", priorityRequest);
		assertEquals("Not an valid Area", response);
	}
	
	@Test
	public void saveUser() {
		User user = new User("awxyz", "awxyz", Role.USER);
		String response  = userServiceImpl.addUser(user);
		assertNotEquals(null, response);
	}
	
	@Test
	public void saveUser_With_Dublicate() {
		User user = new User("awxyz", "awxyz", Role.USER);
		assertEquals("user already exist", userServiceImpl.addUser(user));
	}

}
