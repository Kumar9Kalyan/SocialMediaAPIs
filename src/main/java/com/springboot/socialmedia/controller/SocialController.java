package com.springboot.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.models.SocialUser;
import com.springboot.socialmedia.service.SocialService;

@RestController
public class SocialController {

	@Autowired
	private SocialService socialService;

	@GetMapping("/social/users")
	public ResponseEntity<List<SocialUser>> getUsers() {
		return new ResponseEntity<List<SocialUser>>(socialService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/social/users")
	public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
		return new ResponseEntity<SocialUser>(socialService.saveUser(socialUser), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/social/users/{id}")
	public ResponseEntity<SocialUser> deleteUser(@PathVariable Long id) {
		
		return new ResponseEntity<SocialUser>(socialService.delete(id), HttpStatus.OK);
	}
}
