package com.tatsam.assignment.dao;

import org.springframework.stereotype.Repository;

import com.tatsam.assignment.entity.Areas;

/**
 * 
 * @author sohan
 * @implNote: Area DAO repository
 */

@Repository
public interface AreaDaoRepository {
	
	String saveArea(Areas area);

	boolean isAreaAvaliable(String area);
	
	String saveAreaIfNotExist(Areas area);
	
}
