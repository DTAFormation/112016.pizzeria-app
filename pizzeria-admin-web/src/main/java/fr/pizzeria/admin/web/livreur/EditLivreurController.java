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
 * Servlet implementation class UpdateLivreurController
 */
@WebServlet("/admin/livreurs/edit")
public class EditLivreurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	@Inject private LivreurService livreurService;
	
	private static final Logger LOG = Logger.getLogger(EditLivreurController.class.getName());
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLivreurController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.log(Level.INFO, "livreur update get");
		Livreur liv = livreurService.findAll().stream().filter(l -> l.getId().equals(Integer.parseInt(request.getParameter("code")))).findFirst().get();
		request.setAttribute("livreur", liv);
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/livreurs/addLivreur.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.log(Level.INFO, "livreur update post");
		livreurService.update(new Livreur( Integer.parseInt((String) request.getParameter("id")) ,
											(String) request.getParameter("nom"), 
											(String) request.getParameter("prenom"), 
											(String) request.getParameter("email")));
		LOG.log(Level.INFO, "livreur updated");
		response.sendRedirect(request.getContextPath() + "/admin/livreurs/list");
	}

}
