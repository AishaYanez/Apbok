package com.apbok.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.apbok.backend.entity.services.AppServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

	@Autowired
	private AppServiceImpl appService;
	
	
}
