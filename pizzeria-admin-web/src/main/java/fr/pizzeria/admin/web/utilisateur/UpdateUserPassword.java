package fr.pizzeria.admin.web.utilisateur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.Utilisateur;

@WebServlet("/admin/users/update/password")
public class UpdateUserPassword extends HttpServlet {

	@EJB
	private UtilisateurService uService;

	private static final String VUE_UPDATE_USER_PASSWORD = "/WEB-INF/views/users/updateUsersPassword.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Utilisateur u = uService.getUtilisateurById(id);
		req.setAttribute("user", u);
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_UPDATE_USER_PASSWORD);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String mdp = req.getParameter("hashOutputText").toUpperCase();

		Utilisateur u = new Utilisateur();
		u.setMotDePasse(mdp);
		uService.updateClientPass(id, u);

		resp.sendRedirect(req.getContextPath() + "/admin/users/list");
	}
}
