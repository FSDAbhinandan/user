package com.user.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.entity.UserRole;
import com.user.exceptions.UserIsAlreadyPresentException;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;
import com.user.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<User> createUser(User user, Set<UserRole> userRoles) throws UserIsAlreadyPresentException {
		// TODO Auto-generated method stub
		User local = this.userRepository.findByUsername(user.getUsername());
		System.out.println(user.getUsername()+" "+user.getEmail()+" "+user.getPassword());
//		System.out.println(local.getUsername()+ " "+local.getEmail()+" "+local.getPassword());
		if(local!=null) {
			System.out.println("UserIs Already Present");
//			throw new Exception("UserIs Already Present Exception");
//			return new ResponseEntity<User>(HttpStatus.OK);
			throw new UserIsAlreadyPresentException("User Is Already Present Try With An Other User Name "+local.getUsername());
		}else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getRole().addAll(userRoles);
			local = userRepository.save(user);
		}
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

}
