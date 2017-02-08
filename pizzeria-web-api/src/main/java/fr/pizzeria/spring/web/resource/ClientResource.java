package fr.pizzeria.spring.web.resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;
import fr.pizzeria.spring.web.resource.auth.ClientAuth;

@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	private IClientRepository clientDao;
	
	@Autowired
	private ClientAuth clientAuth;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Client> getClient(@PathVariable Integer id) {
		return clientDao.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutClient(@RequestBody Client user) {
		clientDao.save(user);
	}
	
	@RequestMapping(path="/signin", method = RequestMethod.POST)
	public Map<String,String> connecterClient(@RequestBody Client user) {
		Map<String, String> map = new HashMap<>();
		Client client = clientDao.findByEmailAndMotDePasse(user.getEmail(), user.getMotDePasse());
		if (client != null) {
			map.put("user_id", client.getId().toString());
			map.put("user_nom", client.getNom());
			map.put("user_prenom", client.getPrenom());
			String token = clientAuth.encrypt(client.getEmail());
			System.out.println("Token : " + token);
			map.put("user_token", token);
			String decryptedToken = clientAuth.decrypt(token);
			System.out.println(decryptedToken);
			int index = decryptedToken.indexOf('&');
			String email = decryptedToken.substring(0, index);
			Date date = new Date(Long.valueOf(decryptedToken.substring(index + 1)) * 1000);
			System.out.println("Email : " + email);
			System.out.println("Date : " + date);
			return map;
		} else {
			return null;
		}
	}
	
	public Client getClientByEmail(String email) {
		return clientDao.findByEmail(email);
	}
}
