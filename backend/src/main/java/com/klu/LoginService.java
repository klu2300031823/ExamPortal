package com.klu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	UsersRepository repo;

	public String login(Users LR) {
		// TODO Auto-generated method stub
		Users user= repo.findByusername(LR.getUsername());
		if(user!=null && user.getPassword().equals(LR.getPassword()) ) {
			String role=user.getRole();
			String requestedrole=LR.getRole();
			if(role==requestedrole) {
				if(role=="user") {
			        return "user";
			      }
			      else if(role=="admin") {
			        return "admin";
			      }
			      return "Role not correct";
			      
			    }
			    return "role mismatch";
			  }
			  else {
			    return "user name/password not correct";
			  }
	}
}
