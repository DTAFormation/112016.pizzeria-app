package fr.pizzeria.admin.web.commande;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.admin.metier.CommandeService;
import fr.pizzeria.admin.metier.LivreurService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.web.livreur.EditLivreurController;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Statut;

@WebServlet("/admin/commandes/add")
public class AjouterCommandeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1499261623943289693L;
	private static final String VUE_AJOUTER_COMMANDE 	= "/WEB-INF/views/commandes/creerCommande.jsp";
	private static final String LIST_CONTROLLER		= "/admin/commandes/list";

	private static final Logger LOG = Logger.getLogger(EditLivreurController.class.getName());
	
	
	@Inject private CommandeService commandeService;
	@Inject private ClientService clientService;
	@Inject private LivreurService livreurService;
	@Inject private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.log(Level.INFO, "Get AjouterCommandeController");
		LOG.log(Level.INFO, "recupère la liste des pizzas, clients et des commande");
		req.setAttribute("pizzas", pizzaService.findAll());
		req.setAttribute("clients", clientService.listerClients());
		req.setAttribute("livreurs", livreurService.findAll());
		req.setAttribute("statut", commandeService.getListStatuts());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AJOUTER_COMMANDE);
	    dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.log(Level.INFO, "Post AjouterCommandeController");
		Integer clientId = Integer.parseInt(req.getParameter("client"));
		Integer livreurId = Integer.parseInt(req.getParameter("livreur"));
		LOG.log(Level.INFO, "Liste des items => clientId : " + clientId + " livreurId : " + livreurId + " statut : " + Statut.EN_PREPARATION);
		List<Pizza> pizzas = new ArrayList<>();
		String[] pizzasChoix = req.getParameterValues("choix[]");
		BigDecimal total = new BigDecimal(0);
		LOG.log(Level.INFO, "choix : " + pizzasChoix.length + "pizzas : " + pizzas.size() + " total : " + total);
		if(pizzasChoix.length!=0){
		for(String id : pizzasChoix){
			Pizza pizza = pizzaService.get(Integer.parseInt(id));
			pizzas.add(pizza);
			total = total.add(pizza.getPrix());
		}
		
		commandeService.save(new Commande(clientService.retrieveClient(clientId), livreurService.get(livreurId), total, Statut.EN_PREPARATION, new Date(), pizzas));
		
		LOG.log(Level.INFO, "Commande Sauvegardée.");
		} else {
			LOG.log(Level.WARNING, "Il n'y a pas de pizzas dans la liste.");
		}
		resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER);
		
	}	
}
