package fr.pizzeria.spring.web.resource.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;

@RestController
@RequestMapping("/login")
public class LoginResource {
	
	@Autowired
	private IClientRepository clientDao;
	
	@Autowired
	private ClientAuth clientAuth;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String,String> connecterClient(@RequestBody Client user) {
		Map<String, String> map = new HashMap<>();
		Client client = clientDao.findByEmailAndMotDePasse(user.getEmail(), user.getMotDePasse());
		if (client != null) {
			map.put("user_id", client.getId().toString());
			map.put("user_nom", client.getNom());
			map.put("user_prenom", client.getPrenom());
			String token = clientAuth.encrypt(client.getEmail());
			map.put("user_token", token);
			return map;
		} else {
			return null;
		}
	}
}
