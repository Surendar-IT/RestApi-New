package com.spring.boot.restapi;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)   // AUTO, IDENTITY, SEQUENCE, TABLE
	private Long id;
	
	@NotBlank(message = "User name cannot be null")
	private String userName;
	
	@Email(message="Email should be valid")
	@NotBlank(message = "Email address can not be null")
	//@Column(unique=true)
	private String emailAddress;
	
	@NotBlank(message = "Password cannot be null")
	@Size(min=8, max=20, message = "Password length should be between 8 to 20 characters")
	private String password;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created_At;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date last_Login;
	
	public Project() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	
	public Date getLast_Login() {
		return last_Login;
	}

	public void setLast_Login(Date last_Login) {
		this.last_Login = last_Login;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created_At = new Date();
	}
	
}


