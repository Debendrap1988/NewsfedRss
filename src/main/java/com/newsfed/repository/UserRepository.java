package com.newsfed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsfed.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByFirstNameOrLastNameLike(String firstName, String lastName);
	User findByUserId(String userId);
}
