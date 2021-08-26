package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
//	public User findByUserName(String userName);
	
	@Query("SELECT n FROM User n WHERE n.username = :username")
	public User findByUsername(@Param("username") String username); 
	            

//	public User findByUsername(String username);

}
