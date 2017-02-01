package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Commande;
import fr.pizzeria.spring.web.repository.ICommandeRepository;

@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

	@Autowired
	ICommandeRepository commandeDao;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Commande> getCommandes(@PathVariable Integer id) {
		return commandeDao.findByClientId_Id(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutCommande(@RequestBody Commande commande) {
		commandeDao.save(commande);
	}

}