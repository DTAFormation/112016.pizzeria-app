package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.model.Utilisateur;

/**
 * Contrôleur de la page d'acceuil.
 */
@WebServlet("/admin/home")
public class HomePageController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 705413098257858482L;
	
	private static final String HOME_VIEW = "/WEB-INF/views/home.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		req.setAttribute("user", user);
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(HOME_VIEW);
	    dispatcher.forward(req, resp);
	}
	
	

}
