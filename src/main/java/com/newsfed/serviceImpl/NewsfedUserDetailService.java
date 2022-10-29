package com.newsfed.serviceImpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.newsfed.entity.NewsfedUserDetail;
import com.newsfed.entity.User;
import com.newsfed.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NewsfedUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("loadUserByUsername called ");
		User user = userRepository.findByUserId(userId);
		log.info("USer is :"+user.getRole());
		if(Objects.isNull(user)){
			throw new UsernameNotFoundException("User not found with the UserID :"+userId);
		}
		return new NewsfedUserDetail(user);
	}

}
