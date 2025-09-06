package com.klu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {
	
	
	@Autowired
	
	UsersManager UM;
	@PostMapping("/signup")
	public String signup(@RequestBody Users u) {
		//TODO: process POST request
		
		return UM.addUser(u);
	}
	@PostMapping("/signin")
	public String signin(@RequestBody Users U) {
		//TODO: process POST request
		return UM.validateCredentials(U.getUsername(), U.getPassword() );
	}
	
	@PostMapping("/getfullname")
	public String getfullname(@RequestBody Map<String, String> data) {
		return UM.getFullname(data.get("csrid"));
	}
	
	
}
