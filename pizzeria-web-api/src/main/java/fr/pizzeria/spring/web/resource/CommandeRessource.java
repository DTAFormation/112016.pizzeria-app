package fr.pizzeria.spring.web.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandeClient;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.spring.web.repository.ICommandeRepository;

@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

	@Autowired
	ICommandeRepository commandeDao;

	@Autowired
	private PizzaResource pizzaResource;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Commande> getCommandes(@PathVariable Integer id) {
		return commandeDao.findByClientId_Id(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutCommande(@RequestBody ArrayList<CommandeClient> commandeCleint) {
		List<Pizza> pizza = new ArrayList();
		for (CommandeClient commandeproduit : commandeCleint) {
			if (commandeproduit.getType() == "pizza") {
				pizzaResource.listAllPizzas().stream().filter(p -> p.getCode().equals(commandeproduit.getIdProduit()))
						.findFirst().get();
				pizza.add(pizzaResource.listAllPizzas().stream()
						.filter(p -> p.getCode().equals(commandeproduit.getIdProduit())).findFirst().get());
			}
		}
		// Commande nouvelleCommande = new
		// Commande(commandeCleint.get(0).getIdClient(), "null",
		// commandeCleint.get(0).getQuantite(), Statut.EN_PREPARATION, "date",
		// pizzas);
		// new Commande(idClient, idLivreur, total, statut, date, pizzas);
		// commandeDao.save(commande);
	}

}
