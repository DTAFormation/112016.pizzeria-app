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

import fr.pizzeria.model.Boisson;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandeClient;
import fr.pizzeria.model.CommandeMenu;
import fr.pizzeria.model.Dessert;
import fr.pizzeria.model.Entree;
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
	private EntreeResource entreeResource;

	@Autowired
	private PizzaResource pizzaResource;

	@Autowired
	private BoissonResource boissonResource;

	@Autowired
	private DessertResource dessertResource;

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
		ArrayList<Pizza> pizzas = new ArrayList<>();
		ArrayList<Entree> entrees = new ArrayList<>();
		ArrayList<Boisson> boissons = new ArrayList<>();
		ArrayList<Dessert> desserts = new ArrayList<>();
		ArrayList<CommandeMenu> menus = new ArrayList<>();
		for (CommandeClient commandeproduit : commandeClient) {
			switch(commandeproduit.getType()){
			case "pizza":
				pizzas.add(pizzaResource.listAllPizzas().stream()
						.filter(p -> p.getId().equals(commandeproduit.getIdProduit())).findFirst().get());
				break;
			case "boisson":
				boissons.add(boissonResource.findAll().stream()
						.filter(b -> b.getId().equals(commandeproduit.getIdProduit())).findFirst().get());
				break;
			case "entree":
				entrees.add(entreeResource.findAll().stream()
						.filter(e -> e.getId().equals(commandeproduit.getIdProduit())).findFirst().get());
				break;
			case "dessert":
				desserts.add(dessertResource.findAll().stream()
						.filter(d -> d.getId().equals(commandeproduit.getIdProduit())).findFirst().get());
				break;
			}
		}
		Client client = clientDao.findAll().stream().filter(p -> p.getId().equals(commandeClient.get(0).getIdProduit()))
				.findFirst().get();

		Livreur liveur = liveurDao.findAll().stream().filter(p -> p.getId().equals(1)).findFirst().get();
		commandeDao.save(new Commande(client, liveur, commandeClient.get(0).getTotal(), Statut.EN_PREPARATION,
				new Date(), pizzas, boissons, desserts, entrees, menus));
	}

	public void ajout(Commande commande) {
		commandeDao.save(commande);

	}

}
