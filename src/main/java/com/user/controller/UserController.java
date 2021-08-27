package com.user.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Role;
import com.user.entity.User;
import com.user.entity.UserRole;
import com.user.exceptions.UserIsAlreadyPresentException;
import com.user.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody User user) throws UserIsAlreadyPresentException {
		
		Set<UserRole> roles = new HashSet<UserRole>();
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		Role role = new Role();
		role.setRoleId(45);
		role.setRoleName("NORMAL");
		
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
		
		roles.add(new UserRole(user,role));
		
		return this.userService.createUser(user, roles);
		
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.getUser(username);
	}

}
