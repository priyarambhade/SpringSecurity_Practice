package com.main.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.application.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.email =:email and u.id !=:id")
	User getUserByEmailandId(String email, long id);
	
	@Query("select u from User u where u.email =:email")
	User findByEmail(String email);
	
	@Query("select u from User u where u.mobileNumber =:mobileNumber and u.id !=:id")
	User getUserByMobileNumberandId(String mobileNumber, long id);
}
