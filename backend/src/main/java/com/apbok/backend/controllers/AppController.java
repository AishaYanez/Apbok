package com.apbok.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apbok.backend.entity.models.App;
import com.apbok.backend.entity.services.AppServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

	@Autowired
	private AppServiceImpl appService;
	
	@GetMapping("/apps")
	private List<App> getAllApps(){
		return (List<App>)appService.getAllApps();
	}
	
	@PostMapping("/apps")
	public void postApp(App app) {
	    try {
	        appService.postApp(app);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	
	@DeleteMapping("/apps/{id}")
	private void deleteApp(@PathVariable(name="id") long id){
		try {
			appService.deleteApp(id);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	
	@PutMapping("/apps/{id}")
	private void putApp(@PathVariable(name="id") long id, App app) {
		try {
			appService.putApp(app);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
}