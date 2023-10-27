package com.aisha.appGallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.appGallery.entity.models.App;
import com.aisha.appGallery.entity.models.AppsGallery;
import com.aisha.appGallery.entity.models.AppsGalleryKey;
import com.aisha.appGallery.entity.services.AppsGalleryServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AppsGalleryController {

	@Autowired
	private AppsGalleryServiceImpl appsGalleryService;

	@GetMapping("/apps_galleries")
	private boolean getStatusApp(long userId, long appId) {
		AppsGalleryKey id = new AppsGalleryKey(userId, appId);
		return appsGalleryService.getStatusApp(id);
	}
	
	@PutMapping("/apps_galleries/userId={userId}&appId={appId}")
	private void putStatusApp(@PathVariable long userId,
		    @PathVariable long appId,
		    @RequestParam(name = "favorite") boolean status) {
		AppsGalleryKey id = new AppsGalleryKey(userId, appId);
		appsGalleryService.putStatusApp(id, status);
	}
	
	@GetMapping("/user/{userId}/apps")
    public List<App> getAppsByUserId(@PathVariable(name="userId") long userId) {
        return appsGalleryService.getAppsByUserId(userId);
    }
	
	@PostMapping("/apps_galleries")
	private void postNewApp(@RequestBody AppsGallery appGal) {
		appsGalleryService.postNewApp(appGal);
	}
}
