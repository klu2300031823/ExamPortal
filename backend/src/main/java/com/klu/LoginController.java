package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class LoginController {
	@Autowired
	LoginService LS;
	
	@PostMapping("/login")
	public String login(@RequestBody Users LR) {
		return LS.login(LR);
	}
	
}
