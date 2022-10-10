package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByuserName(String userName);

	public List<User> findByuserNameAndCity(String userName, String City);

	
	//JPQL query
	@Query("select u from User u")
	public List<User> getAllUser();

	@Query("select u from User u WHERE u.userName =:c and u.city =:v")
	public List<User> getUserByuserName(@Param("c") String userName, @Param("v") String city);
	
	// Native Query
	
	@Query(value= "select * from user", nativeQuery = true)
	public List<User> getUserNativeQuery();

}
