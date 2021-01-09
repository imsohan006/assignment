package com.tatsam.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatsam.assignment.entity.Priority;

/**
 * 
 * @author sohan
 * @implNote: Priority DAO repository
 */

@Repository
public interface PriorityDaoRepository {
	
	List<Priority> findAll();
	
	List<Priority> findByUser(String user);
		
	String addPriorityWithSatification(Priority priority);

}
