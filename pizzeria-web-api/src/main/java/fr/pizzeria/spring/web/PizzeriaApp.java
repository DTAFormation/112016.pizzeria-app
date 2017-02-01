package fr.pizzeria.spring.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.spring.web.repository.ILivreurRepository;
import fr.pizzeria.spring.web.resource.ClientResource;
import fr.pizzeria.spring.web.resource.CommandeRessource;
import fr.pizzeria.spring.web.resource.PizzaResource;

/**
 * Application PizzeriaApp démarré via Spring Boot.
 */
@SpringBootApplication
@EntityScan(basePackageClasses = Pizza.class)
public class PizzeriaApp {

	/**
	 * Activation de CORS pour tous les domaines.
	 * 
	 * @return Configurateur Spring MVC.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	/**
	 * Démarrage de l'application Web.
	 *
	 * @param args
	 *            argument du programme
	 */
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApp.class);
	}

	@Autowired
	private PizzaResource pizzaResource;

	@Autowired
	private CommandeRessource commandeRessource;

	@Autowired
	private ClientResource clientResource;

	@Autowired
	ILivreurRepository liveurDao;

	@PostConstruct
	public void setDatabase() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String mode = bundle.getString("post.construct.mode");
		if ("dev".equals(mode)) {

			pizzaResource.ajoutPizza(
					new Pizza("MAR", "margerita", "http://mister-check.e-monsite.com/medias/images/pizza2.jpg",
							new BigDecimal(9.9), 4, 1, CategoriePizza.SANS_VIANDE, new Date()));

			pizzaResource.ajoutPizza(
					new Pizza("PEP", "peperoni", "http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg",
							new BigDecimal(9.9), 3, 1, CategoriePizza.SANS_VIANDE, new Date()));

			pizzaResource.ajoutPizza(
					new Pizza("REI", "reine", "http://astucelle.com/wp-content/uploads/2016/11/image-41.jpeg",
							new BigDecimal(9.52), 6, 2, CategoriePizza.SANS_VIANDE, new Date()));

			pizzaResource.ajoutPizza(new Pizza("CAL", "calzone", "http://www.captainpizza.fr/61/4-familiale-.jpg",
					new BigDecimal(9.52), 6, 2, CategoriePizza.SANS_VIANDE, new Date()));

			List<Pizza> pizzas = pizzaResource.listAllPizzas();

			clientResource.ajoutClient(new Client("ASDRUBAL", "Liv", "liv@gmail.com", "123456", "Cerise"));
			clientResource.ajoutClient(new Client("DEPART", "Arnaud", "arnaud@gmail.com", "123456", "Cerise"));
			clientResource.ajoutClient(new Client("fa", "fawzi", "fawzi@gmail.com", "123456", "Chez lui"));
			clientResource.ajoutClient(new Client("Ville", "kevin", "kevin@gmail.com", "123456", "En Kaz Ay"));

			Client firstClient = clientResource.findAll().stream().filter(client -> client.getId() == 1).findFirst()
					.get();
			Client secondClient = clientResource.findAll().stream().filter(client -> client.getId() == 2).findFirst()
					.get();

			liveurDao.save(new Livreur("Toto", "jooj", "tomtom@gmail.com", "123456"));
			liveurDao.save(new Livreur("Toto2", "jooj2", "tomtom22@gmail.com", "123456"));

			// commandeRessource.ajoutCommande((new Commande(firstClient, null,
			// new BigDecimal(443.9),
			// Statut.EN_PREPARATION, new Date(), pizzas)));
			// commandeRessource.ajoutCommande(
			// (new Commande(firstClient, null, new BigDecimal(25.9),
			// Statut.EN_LIVRAISON, new Date(), pizzas)));
			// commandeRessource.ajoutCommande(
			// (new Commande(secondClient, null, new BigDecimal(535.9),
			// Statut.LIVRER, new Date(), pizzas)));
		}
	}
}
