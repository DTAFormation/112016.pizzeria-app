package fr.pizzeria.admin.web.commande;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.CommandeService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

/**
 * Contrôleur de la page Liste des commandes.
 */
@WebServlet("/admin/commandes/list")
public class ListerCommandeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6842105758155239511L;

	private static final String VUE_LISTER_COMMANDES = "/WEB-INF/views/commandes/listerCommandes.jsp";
	private Logger LOG;

	@Inject
	private CommandeService commandeService;
	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * Traitement du liste <List> CommandePizza => [0,1,2,3] ==> [0]---> MAR
		 * - MAR - REI - CALZ ==> [1]---> REI - REI
		 */

		commandeService.findAll().stream().forEach(System.out::println);

		List<Commande> allCommande = commandeService.findAll();
		List<Pizza> allPizza = pizzaService.findAll();

		allCommande.get(0).setPizzas(allPizza);

		for (Commande commande : allCommande) {

			LOG.log(Level.INFO, commande.toString());
		}

		req.setAttribute("listeCommandes", commandeService.findAll());

		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_LISTER_COMMANDES);
		dispatcher.forward(req, resp);
	}

}
