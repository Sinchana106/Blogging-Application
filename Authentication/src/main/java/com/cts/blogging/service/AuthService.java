package com.cts.blogging.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.blogging.dto.LoginRequest;
import com.cts.blogging.dto.UserRequest;
import com.cts.blogging.model.UserCredentials;

public interface AuthService {

	public UserCredentials signup(UserRequest userRequest);
	public String encodePassword(String password);
	public String login(LoginRequest loginRequest);
	public Boolean validate(String token1 );
}
