package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.Utilisateur;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060577627904685097L;
	
	@EJB
	private UtilisateurService utilisateurService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getSession().getAttribute("user") != null ){
			response.sendRedirect(response.encodeRedirectURL("./admin/home"));
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utilisateur user = utilisateurService.connexion(email, password);
		if(user != null) {
			session.setAttribute("user", user);
			response.sendRedirect(response.encodeRedirectURL("./admin/home"));			
		} else {
			request.setAttribute("erreur", "Email ou mot de passe incorect");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
