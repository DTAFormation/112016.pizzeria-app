package fr.pizzeria.admin.web.livreur;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.LivreurService;
import fr.pizzeria.model.Livreur;

/**
 * Servlet implementation class AjouterLivreur
 */
@WebServlet("/admin/livreurs/add")
public class AjouterLivreurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private LivreurService livreurService;

	private static final Logger LOG = Logger.getLogger(AjouterLivreurController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterLivreurController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.log(Level.INFO, "livreur get post");
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/livreurs/addLivreur.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.log(Level.INFO, "livreur add post");
		livreurService.save(new Livreur((String) request.getParameter("nom"), (String) request.getParameter("prenom"),
				(String) request.getParameter("email")));
		response.sendRedirect(request.getContextPath() + "/admin/livreurs/add");
	}

}
