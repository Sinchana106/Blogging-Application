package com.cts.blogging.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Entity
@Table(name="user")
public class UserCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp = "^[A-Za-z0-9]+$",message = "User name should be only alphanumeric")
	@Column(name="user_name")
	private String username;
	@NotBlank(message = "Password cannot be blank")
	@Column(name="password")
	private String password;
	@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9.]+$",message = "Email should match the following format abc@xyz.com")
	@Column(name="email_id")
	private String emailid;
	@Pattern(regexp = "^[7,8,9][0-9]{9}$", message = "Phone number length should be 10")
	@Column(name="phno")
	private String  phno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailid;
	}
	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public UserCredentials(int id,
			@Pattern(regexp = "^[A-Za-z0-9]+$", message = "User name should be only alphanumeric") String userName,
			@NotBlank(message = "Password cannot be blank") String password,
			@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9.]+$", message = "Email should match the following format abc@xyz.com") String emailId,
			@Pattern(regexp = "^[7,8,9][0-9]{9}$", message = "Phone number length should be 10") String phno) {
		super();
		this.id = id;
		this.username = userName;
		this.password = password;
		this.emailid = emailId;
		this.phno = phno;
	}
	public UserCredentials() {
		super();
	}
}
