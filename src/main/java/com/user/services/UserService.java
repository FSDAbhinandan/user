package com.user.services;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.entity.UserRole;
import com.user.exceptions.UserIsAlreadyPresentException;

@Service
public interface UserService {

	//Creating user
	public ResponseEntity<User> createUser(User user, Set<UserRole> userRoles) throws UserIsAlreadyPresentException;
	public User getUser(String username);
}
