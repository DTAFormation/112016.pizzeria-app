package fr.pizzeria.spring.web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandeClient;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Statut;
import fr.pizzeria.spring.web.repository.IClientRepository;
import fr.pizzeria.spring.web.repository.ICommandeRepository;
import fr.pizzeria.spring.web.repository.ILivreurRepository;

@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

	@Autowired
	ICommandeRepository commandeDao;

	@Autowired
	private PizzaResource pizzaResource;

	@Autowired
	IClientRepository clientDao;

	@Autowired
	ILivreurRepository liveurDao;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Commande> getCommandes(@PathVariable Integer id) {
		return commandeDao.findByClientId_Id(id);
	}

	@RequestMapping(path = "/commande/{id}", method = RequestMethod.GET)
	public List<Commande> getClient(@PathVariable Integer id) {
		return commandeDao.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutCommande(@RequestBody ArrayList<CommandeClient> commandeClient) {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		for (CommandeClient commandeproduit : commandeClient) {

			if (commandeproduit.getType().equals("pizza")) {
				pizzas.add(pizzaResource.listAllPizzas().stream()
						.filter(p -> p.getId().equals(commandeproduit.getIdProduit())).findFirst().get());

			}
		}
		Client client = clientDao.findAll().stream().filter(p -> p.getId().equals(commandeClient.get(0).getIdProduit()))
				.findFirst().get();

		Livreur liveur = liveurDao.findAll().stream().filter(p -> p.getId().equals(1)).findFirst().get();
		commandeDao.save(new Commande(client, liveur, commandeClient.get(0).getTotal(), Statut.EN_PREPARATION,
				new Date(), pizzas));
	}

	public void ajout(Commande commande) {
		commandeDao.save(commande);

	}

}
