package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;

@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	private IClientRepository clientDao;

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
	public Client connecterClient(@RequestBody Client user) {
		return clientDao.findByEmailAndMotDePasse(user.getEmail(), user.getMotDePasse());
	}
}
