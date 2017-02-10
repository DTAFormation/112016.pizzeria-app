package fr.pizzeria.spring.web.resource;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/client")
public class ClientResource {

	private Logger LOG  = Logger.getLogger(ClientResource.class.getName());

	@Autowired
	private IClientRepository clientDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> getClient(HttpServletRequest request) {
		Client client = (Client) request.getAttribute("userAuth");
		return clientDao.findById(client.getId());
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutClient(@RequestBody Client user) {
		clientDao.save(user);
	}

	public Client getClientByEmail(String email) {
		return clientDao.findByEmail(email);
	}
}
