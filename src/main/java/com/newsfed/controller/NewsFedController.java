package com.newsfed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newsfed.dto.NewsfedDto;
import com.newsfed.service.NewsfedServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/newsfed")
public class NewsFedController {

	@Autowired
	private NewsfedServices newsfedServices;

	@Autowired
	Environment env;

	@GetMapping
	public ResponseEntity<List<NewsfedDto>> getAllNewsFed() {
		log.info("Getting all newsFed");
		return new ResponseEntity<List<NewsfedDto>>(newsfedServices.getAllNewsFed(), HttpStatus.OK);
	}

	@PostMapping(path = "/manager")
	public ResponseEntity<NewsfedDto> createNewsFed(@RequestBody NewsfedDto newsfedDto) {
		log.info("creating one newsFed");
		return new ResponseEntity<NewsfedDto>(newsfedServices.createNewsFed(newsfedDto), HttpStatus.OK);
	}

	@PutMapping(path = "/manager")
	public ResponseEntity<NewsfedDto> updateNewsFed(@RequestBody NewsfedDto newsfedDto) {
		log.info("updating one newsFed");
		return new ResponseEntity<NewsfedDto>(newsfedServices.updateNewsFed(newsfedDto), HttpStatus.OK);
	}

	@DeleteMapping(path = "/manager")
	public ResponseEntity<NewsfedDto> deleteNewsFed(@RequestParam(name = "newsfedId", required = true) Long newsfedId) {
		log.info("deleting one newsFed");
		return new ResponseEntity<NewsfedDto>(newsfedServices.deleteNewsFed(newsfedId), HttpStatus.OK);
	}

	@GetMapping(path = "/manager/sendallactivenewsfed")
	public ResponseEntity<List<NewsfedDto>> sendAllActiveNewsFed() {
		return new ResponseEntity<List<NewsfedDto>>(newsfedServices.sendActiveNewsfedToUsers(), HttpStatus.OK);
	}
}
