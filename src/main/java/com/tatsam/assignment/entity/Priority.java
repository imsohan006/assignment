package com.tatsam.assignment.entity;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class Priority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String user;
	
	@NotNull
	private String area;
	
	@NotNull
	private int priority;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int satisfaction;
	
	@CreatedDate
	private Timestamp createTimestamp;

	public Priority() {
		// TODO Auto-generated constructor stub
	}
	
	public Priority(@NotNull String user, @NotNull String area, @NotNull int priority,
			@NotNull @Min(1) @Max(5) int satisfaction) {
		super();
		this.user = user;
		this.area = area;
		this.priority = priority;
		this.satisfaction = satisfaction;
		this.createTimestamp = new Timestamp(System.currentTimeMillis());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	
	
	

}
