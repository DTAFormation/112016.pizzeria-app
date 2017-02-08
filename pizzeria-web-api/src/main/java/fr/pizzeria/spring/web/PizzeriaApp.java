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

import fr.pizzeria.model.Boisson;
import fr.pizzeria.model.CategorieBoisson;
import fr.pizzeria.model.CategorieDessert;
import fr.pizzeria.model.CategorieEntree;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Dessert;
import fr.pizzeria.model.Entree;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Menu;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Promotion;
import fr.pizzeria.model.Statut;
import fr.pizzeria.spring.web.repository.ILivreurRepository;
import fr.pizzeria.spring.web.repository.IPromotionRepository;
import fr.pizzeria.spring.web.resource.BoissonResource;
import fr.pizzeria.spring.web.resource.ClientResource;
import fr.pizzeria.spring.web.resource.CommandeRessource;
import fr.pizzeria.spring.web.resource.DessertResource;
import fr.pizzeria.spring.web.resource.EntreeResource;
import fr.pizzeria.spring.web.resource.MenuResource;
import fr.pizzeria.spring.web.resource.PizzaResource;
import fr.pizzeria.spring.web.resource.PromotionRessource;

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
	private DessertResource dessertRessource;

	@Autowired
	private BoissonResource boissonRessource;

	@Autowired
	private EntreeResource entreeRessource;

	@Autowired
	private MenuResource menuRessource;

	@Autowired
	ILivreurRepository liveurDao;

	@Autowired
	private PromotionRessource promotionRessource;
	
	
	@PostConstruct
	public void setDatabase() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String mode = bundle.getString("post.construct.mode");
		if ("dev".equals(mode)) {
			
			Promotion promo1 = new Promotion("special Noel","noel2017", "monetaire", 10);
			Promotion promo2 = new Promotion("special lundi","I<3monday", "monetaire", 20);
			Promotion promo3 = new Promotion("special saint valentin","<3<3", "pourcentage", 10);
			promotionRessource.ajoutPromotion(promo1);
			promotionRessource.ajoutPromotion(promo2);
			promotionRessource.ajoutPromotion(promo3);

			Menu menu = new Menu("Menu enfant", new BigDecimal(10.20),
					"http://www.mitango.restaurant/accueil/images/menu-kids.jpg", 0, 1, 1, 1);
			Menu menu2 = new Menu("Menu famille", new BigDecimal(40.20),
					"http://www.lesmarinesdesuresnes.fr/wp-content/uploads/logo-menu.jpg", 3, 3, 3, 3);
			Menu menu3 = new Menu("Menu grosse faim", new BigDecimal(40.20),
					"http://www.lesmarinesdesuresnes.fr/wp-content/uploads/logo-menu.jpg", 0, 2, 1, 1);
			menuRessource.ajoutMenu(menu);
			menuRessource.ajoutMenu(menu2);
			menuRessource.ajoutMenu(menu3);

			Boisson boisson = new Boisson("coca", new BigDecimal(2.5),
					"http://media.topito.com/wp-content/uploads/2014/12/coca-250x250.jpg", CategorieBoisson.GAZ);
			Boisson boisson2 = new Boisson("oasis tropical", new BigDecimal(2.0),
					"http://medine-distribution.fr/219-home_default/oasis-tropical-50cl-x-24.jpg",
					CategorieBoisson.SANS_GAZ);
			Boisson boisson3 = new Boisson("evian", new BigDecimal(1.5),
					"http://www.galerieculinaireparis.com/755-home_default/o4-evian-1l.jpg", CategorieBoisson.SANS_GAZ);
			boissonRessource.ajoutBoisson(boisson);
			boissonRessource.ajoutBoisson(boisson2);
			boissonRessource.ajoutBoisson(boisson3);

			entreeRessource.ajoutEntree(new Entree("Verrine de crevette", new BigDecimal(12.25),
					"http://static.750g.com/images/200-160/667cadcb25da94adb772f1b48acfef42/verrines-de-crevettes-au-pamplemousse-et-a-la-pomme.png",
					CategorieEntree.POISSON));

			// client 1
			pizzaResource.ajoutPizza(
					new Pizza("MAR", "margerita", "http://mister-check.e-monsite.com/medias/images/pizza2.jpg",
							new BigDecimal(9.9), 0, 0, CategoriePizza.VIANDE, new Date(), 0));

			clientResource.ajoutClient(new Client("ASDRUBAL", "Liv", "liv@gmail.com", "123456", "Cerise"));

			List<Pizza> pizzas = pizzaResource.listAllPizzas();

			Client firstClient = clientResource.findAll().stream().filter(client -> client.getId() == 1).findFirst()
					.get();
			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(443.9), Statut.EN_PREPARATION,
					new Date(), pizzas, null, null, null, null)));
			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(443.9), Statut.PRET, new Date(),
					pizzas, null, null, null, null)));

			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(443.9), Statut.EN_PREPARATION,
					new Date(), pizzas, null, null, null, null)));
			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(443.9), Statut.PRET, new Date(),
					pizzas, null, null, null, null)));

			// ----------------------------------------
			pizzaResource.ajoutPizza(
					new Pizza("PEP", "peperoni", "http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg",
							new BigDecimal(9.9), 0, 0, CategoriePizza.VIANDE, new Date(), 0));

			pizzaResource.ajoutPizza(
					new Pizza("REI", "reine", "http://astucelle.com/wp-content/uploads/2016/11/image-41.jpeg",
							new BigDecimal(9.52), 0, 0, CategoriePizza.SANS_VIANDE, new Date(), 0));

			pizzaResource.ajoutPizza(new Pizza("CAL", "calzone", "http://www.captainpizza.fr/61/4-familiale-.jpg",
					new BigDecimal(9.52), 0, 0, CategoriePizza.SANS_VIANDE, new Date(), 0));

			pizzas = pizzaResource.listAllPizzas();

			clientResource.ajoutClient(new Client("DEPART", "Arnaud", "arnaud@gmail.com", "123456", "Cerise"));
			clientResource.ajoutClient(new Client("fa", "fawzi", "fawzi@gmail.com", "123456", "Chez lui"));
			clientResource.ajoutClient(new Client("Ville", "kevin", "kevin@gmail.com", "123456", "En Kaz Ay"));

			Client secondClient = clientResource.findAll().stream().filter(client -> client.getId() == 2).findFirst()
					.get();

			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(443.9), Statut.EN_PREPARATION,
					new Date(), pizzas, null, null, null, null)));
			commandeRessource.ajout((new Commande(firstClient, null, new BigDecimal(25.9), Statut.EN_LIVRAISON,
					new Date(), pizzas, null, null, null, null)));
			commandeRessource.ajout((new Commande(secondClient, null, new BigDecimal(535.9), Statut.LIVRER, new Date(),
					pizzas, null, null, null, null)));

			Dessert dessert = new Dessert("tiramisu", new BigDecimal(2.50),
					"http://sf1.viepratique.fr/wp-content/uploads/sites/2/2014/05/217170.jpg", CategorieDessert.GLUTEN);

			Dessert dessert2 = new Dessert("crêpe Bretonne", new BigDecimal(2.00),
					"http://www.recettes-bretonnes.fr/wp-content/Photos/millefeuille-crepe.jpg",
					CategorieDessert.SANS_GLUTEN);
			Dessert d3 =  new Dessert("Crumble fruits rouges", new BigDecimal(2.40),"http://img-3.journaldesfemmes.com/GAMtWkdxTGj4DNksByg-Edt-I0s=/750x/smart/image-icu/370448_7659566846.jpg",CategorieDessert.GLUTEN);

			dessertRessource.ajoutDessert(dessert);
			dessertRessource.ajoutDessert(dessert2);
			dessertRessource.ajoutDessert(d3);

			liveurDao.save(new Livreur("Toto", "jooj", "tomtom@gmail.com", "123456"));
			liveurDao.save(new Livreur("Toto2", "jooj2", "tomtom22@gmail.com", "123456"));

		}
	}
}
