package com.cts.blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.blogging.dto.UserRequest;
import com.cts.blogging.model.UserCredentials;
@Repository
public interface UserRepository extends JpaRepository<UserCredentials, Integer> {
	public UserCredentials findByUsername(String userName);
}
