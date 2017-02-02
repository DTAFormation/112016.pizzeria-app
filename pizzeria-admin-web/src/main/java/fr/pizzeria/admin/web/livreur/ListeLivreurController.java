package fr.pizzeria.admin.web.livreur;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.LivreurService;

/**
 * Servlet implementation class ListeLivreurController
 */
@WebServlet("/admin/livreurs/list")
public class ListeLivreurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Inject private LivreurService livreurService;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeLivreurController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeDeLivreur", this.livreurService.findAll());
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/livreurs/listerLivreurs.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
