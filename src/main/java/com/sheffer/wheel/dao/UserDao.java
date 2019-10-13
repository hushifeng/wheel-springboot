package com.sheffer.wheel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sheffer.wheel.doamin.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
//	Optional<User> findById(String id);//default extends CurdJpaRepository
	User findByUserName(String userName);
	
	@Query("FROM User WHERE age = :age AND userName = :userName")
	List<User> findUserByAgeAndUserName(@Param("age") int age, @Param("userName") String userName);
	
//	@Query(nativeQuery = true, value = "SELECT * FROM USER WHERE id = :id AND userName = :userName")
//	List<User> findSQL(@Param("id") String id, @Param("userName") String userName);
}
