package com.newsfed.service;

import java.util.List;

import com.newsfed.dto.NewsfedDto;

public interface NewsfedServices {
	
	List<NewsfedDto> getAllNewsFed();
	NewsfedDto createNewsFed(NewsfedDto NewsfedDto);
	NewsfedDto updateNewsFed(NewsfedDto NewsfedDto);
	NewsfedDto deleteNewsFed(Long newsfedId);
	List<NewsfedDto> sendActiveNewsfedToUsers();
}
