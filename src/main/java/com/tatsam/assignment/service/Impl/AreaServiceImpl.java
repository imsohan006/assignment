package com.tatsam.assignment.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.assignment.dao.Impl.AreaDaoImpl;
import com.tatsam.assignment.entity.Areas;

@Service
public class AreaServiceImpl {
	
	@Autowired
	private AreaDaoImpl areaDaoImpl;
	
	
	public String addArea(Areas area) {
		return areaDaoImpl.saveAreaIfNotExist(area);		
	}

}
