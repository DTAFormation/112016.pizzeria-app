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
import fr.pizzeria.admin.web.pizza.ListerPizzaController;

/**
 * Servlet implementation class DeleteLivreurController
 */
@WebServlet("/admin/livreurs/delete")
public class DeleteLivreurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject LivreurService livreurService; 
       
	private static final Logger LOG = Logger.getLogger(DeleteLivreurController.class.getName());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLivreurController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.log(Level.INFO, "Livreur delete get" );
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/admin/livreurs/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.log(Level.INFO, "Livreur delete post" );
		
		livreurService.delete(Integer.parseInt((String)request.getParameter("IdLivreur")));
		response.sendRedirect(request.getContextPath() + "/admin/livreurs/list");
	}

}
