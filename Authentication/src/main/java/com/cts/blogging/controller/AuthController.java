package com.cts.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.blogging.dto.LoginRequest;
import com.cts.blogging.dto.UserRequest;
import com.cts.blogging.model.UserCredentials;
import com.cts.blogging.service.AuthServiceImpl;
import com.cts.blogging.util.JwtProvider;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private AuthServiceImpl authServiceImpl;
	
	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/signup")
	public ResponseEntity<UserCredentials> signup(@RequestBody UserRequest request) {
		System.out.println(request.toString());
		authServiceImpl.signup(request);
		return new ResponseEntity<UserCredentials>(HttpStatus.OK);
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.toString());
		return authServiceImpl.login(loginRequest);
	}
	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name="Authorization") String token1 ) {
		try {
			if(authServiceImpl.validate(token1)==true) {
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(false,HttpStatus.FORBIDDEN);
			}
		}
		catch(Exception exception) {
			return new ResponseEntity<>(false,HttpStatus.FORBIDDEN);
		}

		
	}
	
	@GetMapping("/username")
	public String getUserName(@RequestHeader(name="Authorization") String token1 ) {
		System.out.println(token1.substring(7));
		return jwtProvider.extractUsername(token1.substring(7));
	}
}
