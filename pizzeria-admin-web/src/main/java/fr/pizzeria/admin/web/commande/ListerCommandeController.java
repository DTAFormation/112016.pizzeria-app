package fr.pizzeria.admin.web.commande;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.CommandeService;

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

	@Inject
	private CommandeService commandeService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listeCommandes", commandeService.findAll());
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_LISTER_COMMANDES);
		dispatcher.forward(req, resp);
	}

}
