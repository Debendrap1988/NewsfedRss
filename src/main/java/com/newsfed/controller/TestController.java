package com.newsfed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping
	public ResponseEntity<String> msg(){
		return new ResponseEntity<>("How are you today ...?", HttpStatus.ACCEPTED);
	}
}
