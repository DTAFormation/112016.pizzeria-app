package fr.pizzeria.spring.web.resource;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;

@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	private IClientRepository ClientDao;

	@PostConstruct
	public void setDatabaseClient() {
		ClientDao.save(new Client("ASDRUBAL", "Liv", "liv@gmail.com", "123456", "Cerise"));
		ClientDao.save(new Client("DEPART", "Arnaud", "arnaud@gmail.com", "123456", "Cerise"));
		ClientDao.save(new Client("fa", "fawzi", "fawzi@gmail.com", "123456", "Chez lui"));
		ClientDao.save(new Client("Ville", "kevin", "kevin@gmail.com", "123456", "En Kaz Ay"));
	}

	@CrossOrigin
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Client> getClient(@PathVariable Integer id) {
		return ClientDao.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutClient(@RequestBody Client user) {
		ClientDao.save(user);
	}
}
