package com.aisha.appGallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.appGallery.entity.models.App;
import com.aisha.appGallery.entity.services.AppServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AppController {
	
	@Autowired
	private AppServiceImpl appService;
	
	@GetMapping("/apps")
	private List<App> getAllApps(){
		return (List<App>)appService.getAllApps();
	}
}