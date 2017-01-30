package fr.pizzeria.spring.web.resource;

import java.util.List;

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
	private IClientRepository ClientDao;

	@RequestMapping(method = RequestMethod.POST)
	public boolean login(@RequestBody List<String> login) {

		List<Client> clients = ClientDao.findAll();

		for (Client c : clients) {
			if ((login.get(0).equals(c.getEmail())) && (login.get(1).equals(c.getMotDePasse()))) {
				return true;
			}
		}

		return false;
	}

}
