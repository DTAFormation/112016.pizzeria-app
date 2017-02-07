package fr.pizzeria.admin.web.commande;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

@WebServlet("/admin/commandes/edit")
public class EditerCommandeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2376353383377147562L;
	private static final String VUE_AJOUTER_COMMANDE = "/WEB-INF/views/commandes/editerCommande.jsp";
	private static final String LIST_CONTROLLER = "/admin/commandes/list";

	@Inject
	private CommandeService commandeService;
	@Inject
	private ClientService clientService;
	@Inject
	private LivreurService livreurService;
	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("pizzas", pizzaService.findAll());
		req.setAttribute("clients", clientService.listerClients());
		req.setAttribute("livreurs", livreurService.findAll());
		req.setAttribute("commande", commandeService.findAll().get(id - 1));

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AJOUTER_COMMANDE);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idCommande = req.getParameter("id");
		Commande commande = commandeService.get(Integer.parseInt(idCommande));

		Integer clientId = Integer.parseInt(req.getParameter("clientId"));
		Integer livreurId = Integer.parseInt(req.getParameter("livreurId"));

		List<Pizza> pizzas = new ArrayList<>();
		String[] parameterValues = req.getParameterValues("pizzas");

		BigDecimal total = new BigDecimal(0);
		for (String id : parameterValues) {
			Pizza pizza = pizzaService.get(Integer.parseInt(id));
			pizzas.add(pizza);
			total = total.add(pizza.getPrix());
		}

		commande.setClientId(clientService.retrieveClient(clientId));
		commande.setLivreurId(livreurService.get(livreurId));
		commande.setPizzas(pizzas);
		commande.setTotal(total);
		// commande.setStatut(statut);

		commandeService.update(commande, Integer.parseInt(idCommande));
		resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER);

	}
}
