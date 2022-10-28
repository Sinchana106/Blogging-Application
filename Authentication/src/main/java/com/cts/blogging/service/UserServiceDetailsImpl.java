package com.cts.blogging.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cts.blogging.model.UserCredentials;
import com.cts.blogging.repository.UserRepository;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserCredentials credentials = repository.findByUsername(username);
		return new User(credentials.getUserName(), credentials.getPassword(), new ArrayList<>());

	}
}
