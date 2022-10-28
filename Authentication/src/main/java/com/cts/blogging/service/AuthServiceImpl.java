package com.cts.blogging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.blogging.dto.LoginRequest;
import com.cts.blogging.dto.UserRequest;
import com.cts.blogging.exceptions.TokenNotValidException;
import com.cts.blogging.exceptions.UserNotFoundException;
import com.cts.blogging.model.UserCredentials;
import com.cts.blogging.repository.UserRepository;
import com.cts.blogging.util.JwtProvider;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceDetailsImpl userDetailsService;
	@Autowired
	private JwtProvider jwtProvider;

	final static Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Override
	public UserCredentials signup(UserRequest userRequest) {

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUserName(userRequest.getUsername());
		userCredentials.setEmailId(userRequest.getEmailid());
		userCredentials.setPassword(encodePassword(userRequest.getPassword()));
		userCredentials.setPhno(userRequest.getPhno());
		return repository.save(userCredentials);

	}

	@Override
	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public String login(LoginRequest loginRequest) {

		if (loginRequest.getUsername() == null || loginRequest.getPassword() == null
				|| loginRequest.getUsername().trim().isEmpty() || loginRequest.getPassword().trim().isEmpty()) {
			log.debug("Login unsuccessful --> User name or password is empty");
			throw new UserNotFoundException("User name or password cannot be Null or Empty");
		} else {
			try {
				UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());
				System.out.println(user);
				log.debug(encodePassword(loginRequest.getPassword()) + " " + user.getPassword());

				if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
					log.debug("true");

					String token = jwtProvider.generateToken(loginRequest.getUsername());
					log.debug("Login successful");
					return token;
				} else {
					log.debug("Login unsuccessful --> Invalid password");
					throw new UserNotFoundException("Password is wrong");
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("Login unsuccessful --> Invalid Credential");
				throw new UserNotFoundException("Invalid Credential");
			}
		}
	}

	public Boolean validate(String token1 ) {
		String token=token1.substring(7);
		log.debug(token);
		try {
			log.debug("after try");
			UserDetails userDetails= userDetailsService.loadUserByUsername(jwtProvider.extractUsername(token));
			log.debug(userDetails.toString());
			if(jwtProvider.validateToken(token, userDetails)) {
				log.debug("2");
				return true;
				
			}else {
				log.debug("3");
				return false;
				
			}
		
	}
		catch(Exception exception){
			log.debug("4");
			throw new TokenNotValidException("Token is not Valid");
			
		}
}
}
