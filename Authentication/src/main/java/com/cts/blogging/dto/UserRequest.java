package com.cts.blogging.dto;

public class UserRequest {

private int id;
	
	
	private String username;
	
	private String password;
	
	
	private String emailid;
	
	private String  phno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public UserRequest(int id, String username, String password, String emailid, String phno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.phno = phno;
	}

	public UserRequest() {
		super();
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", username=" + username + ", password=" + password + ", emailid=" + emailid
				+ ", phno=" + phno + "]";
	}

}