package com.newsfed.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsfed.dto.NewsfedDto;
import com.newsfed.entity.Newsfed;
import com.newsfed.repository.NewsfedRepository;
import com.newsfed.service.NewsfedServices;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class NewsfedServicesImpl implements NewsfedServices{
	
	@Autowired
	private NewsfedRepository newsfedRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<NewsfedDto> getAllNewsFed() {
		log.info("getAllNewsFed called to get all newsFed");
		return newsfedRepository.findAll().stream().map(newsfed -> modelMapper.map(newsfed, NewsfedDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public NewsfedDto createNewsFed(NewsfedDto newsfedDto) {
		log.info("createNewsFed called to creating one newsFed");
		Date currentTime = new Date();
		newsfedDto.setCreatedDate(currentTime);
		newsfedDto.setModifiedDate(currentTime);
		newsfedDto.setPublishedDate(currentTime);
		newsfedDto.setId(newsfedRepository.save(modelMapper.map(newsfedDto, Newsfed.class)).getId());
		return newsfedDto;
	}

	@Override
	public NewsfedDto updateNewsFed(NewsfedDto newsfedDto) {
		log.info("updateNewsFed called to update one newsFed with id :"+newsfedDto.getId());
		Newsfed newsfed = newsfedRepository.getById(newsfedDto.getId());
		newsfed.setModifiedDate(new Date());
		newsfed.setHeader(newsfedDto.getHeader());
		newsfed.setDescription(newsfedDto.getDescription());
		newsfedRepository.save(newsfed);
		return newsfedDto;
	}

	@Override
	public NewsfedDto deleteNewsFed(Long newsfedId) {
		log.info("deleteNewsFed called to delete one newsFed with id :"+newsfedId);
		Newsfed newsfed = newsfedRepository.getById(newsfedId);
		newsfed.setDeleted(true);
		modelMapper.map(newsfedRepository.save(newsfed), NewsfedDto.class);
		return modelMapper.map(newsfedRepository.save(newsfed), NewsfedDto.class);
	}

	@Override
	public List<NewsfedDto> sendActiveNewsfedToUsers() {
		log.info("sendActiveNewsfedToUsers called to send all active newsFeds");
		List<Newsfed> newsfedList = newsfedRepository.findBySentStatusAndDeleted(false, false);
		log.info("marking all sent newsfeds as sent status true so that next time these fewd won't go");
		newsfedList.stream().forEach(nf-> nf.setSentStatus(true));
		newsfedRepository.saveAll(newsfedList);
		return newsfedList.stream().map(nf -> convertToNewdfedDto(nf)).collect(Collectors.toList());
	}
	
	private NewsfedDto convertToNewdfedDto(Newsfed newsfed){
		NewsfedDto newsfedDto = new NewsfedDto();
		newsfedDto.setHeader(newsfed.getHeader());
		newsfedDto.setDescription(newsfed.getDescription());
		return newsfedDto;
	}
	
}
