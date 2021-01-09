package com.tatsam.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
    @Column(nullable=false, unique = true)
    @NotEmpty(message = "Please provide the username")
    private String user;
    
    @Column(nullable=false)
    @NotEmpty(message = "Please provide the password")
    @Size(min=4)
    private String password;
 
    @Enumerated(EnumType.STRING)
    private Role role;
 
    public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(@NotEmpty(message = "Please provide the username") String user,
			@NotEmpty @Size(min = 4) String password, Role role) {
		super();
		this.user = user;
		this.password = password;
		this.role = role;
	}

	public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Role getRole()
    {
        return role;
    }
    
    public void setRoles(Role role)
    {
        this.role = role;
    }
}
