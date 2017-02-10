package fr.pizzeria.spring.web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.spring.web.filter.AuthentificationFilter;
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

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

    private Logger LOG  = Logger.getLogger(AuthentificationFilter.class.getName());

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
	private CommandeMenuRessource commandeMenuResource;
	
	@Autowired
	private MenuResource menuResource;

	@Autowired
	IClientRepository clientDao;

	@Autowired
	ILivreurRepository liveurDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Commande> getCommandes(HttpServletRequest request) {
		Client client = (Client) request.getAttribute("userAuth");
		return commandeDao.findByClientId(client.getId());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Commande getCommande(@PathVariable Integer id, HttpServletRequest request) {
	    Client client = (Client) request.getAttribute("userAuth");
		return commandeDao.findByIdAndClientId(id, client.getId());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutCommande(@RequestBody ArrayList<CommandeClient> commandeClient) {
		ArrayList<Pizza> pizzas = new ArrayList<>();
		ArrayList<Entree> entrees = new ArrayList<>();
		ArrayList<Boisson> boissons = new ArrayList<>();
		ArrayList<Dessert> desserts = new ArrayList<>();
		ArrayList<CommandeMenu> menus = new ArrayList<>();
		for (CommandeClient commandeproduit : commandeClient) {
			for (int i=0; i<commandeproduit.getQuantite(); i++) {
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
				case "menu":
					/*menus.add(menuResource.findAll().stream()
							.filter(d -> d.getId().equals(commandeproduit.getIdProduit())).findFirst().get());*/
					break;
				}
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
