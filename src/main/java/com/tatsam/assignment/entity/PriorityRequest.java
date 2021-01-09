package com.tatsam.assignment.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class PriorityRequest {
	
	@NotEmpty(message = "Please specified the area for priority")
	private String area;
	
	@NotNull(message = "Please specified the priority value")
	private int priority;
	
	@NotNull(message = "Please specified the satification from 1 to 5 for the choosen area")
	@Range(min = 1, max = 5)
	private int satification;

	public PriorityRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public PriorityRequest(@NotEmpty(message = "Please specified the area for priority") String area,
			@NotEmpty(message = "Please specified the priority value") int priority,
			@NotEmpty(message = "Please specified the satification from 1 to 5 for the choosen area") @Range(min = 1, max = 5) int satification) {
		super();
		this.area = area;
		this.priority = priority;
		this.satification = satification;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getSatification() {
		return satification;
	}


	public void setSatification(int satification) {
		this.satification = satification;
	}
	
	

}
