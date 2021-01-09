package com.tatsam.assignment.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.assignment.dao.Impl.AreaDaoImpl;
import com.tatsam.assignment.dao.Impl.PriorityDaoImpl;
import com.tatsam.assignment.entity.Priority;
import com.tatsam.assignment.entity.PriorityRequest;

@Service
public class PriorityServiceImpl {
	
	@Autowired
	private PriorityDaoImpl priorityDaoImpl;
	
	@Autowired
	private AreaDaoImpl areaDaoImpl;
	
	public List<Priority> getAllPriorityList(){
		return priorityDaoImpl.findAll();	
	}
	
	public List<Priority> getPriorityListByUser(String user){
		return priorityDaoImpl.findByUser(user);	
	}
	
	public String addPriorityWithSatification(String user, PriorityRequest priorityRequest){
		if(areaDaoImpl.isAreaAvaliable(priorityRequest.getArea())) {
			Priority priority = new Priority(user, priorityRequest.getArea(), priorityRequest.getPriority(), priorityRequest.getSatification());
			return priorityDaoImpl.addPriorityWithSatification(priority);	
		}
		return "Not an valid Area";
	}

}
