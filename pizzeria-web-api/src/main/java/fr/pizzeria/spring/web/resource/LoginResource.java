package fr.pizzeria.spring.web.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginResource {
	
	@RequestMapping(method = RequestMethod.POST)
	public boolean login(String email, String mdp){
		
		
		return true;
	}
	
}
