package com.tatsam.assignment.dao;


import org.springframework.stereotype.Repository;

import com.tatsam.assignment.entity.User;

/**
 * 
 * @author sohan
 * @implNote: User DAO repository
 */

@Repository
public interface UserDaoRepository {
	
	String addUser(User user);
	
	String deleteUser(long id);
	
	String addIfNotExist(User user);
	
	boolean userExists(String username);
	
	User findByUser(String username);

}
