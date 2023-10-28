package com.apbok.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apbok.backend.entity.models.User;
import com.apbok.backend.entity.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/users")
	public ResponseEntity<User> getUser(@RequestParam(value = "email") String email) {
	    try {
	        User user = userService.getUser(email);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@GetMapping("/users/all")
	private List<User> getAllUsers(){
		return(List<User>)  userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> postUser(User user) {
	    try {
	        userService.postUser(user);
	        return ResponseEntity.ok("Usuario creado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@DeleteMapping("/users")
	private ResponseEntity<String> deleteUser(@RequestParam(value = "email") String email){
		try {
			userService.deleteUser(email);
	        return ResponseEntity.ok("Usuario borrado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@PutMapping("/users")
	private ResponseEntity<String> putUser(@RequestParam(value = "email") String email, String password) {
		try {
			System.out.print("hasta aqui llega");
			userService.putPassword(email, password);
	        return ResponseEntity.ok("Usuario actualizado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
}