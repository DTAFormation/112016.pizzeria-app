package fr.pizzeria.admin.web.utilisateur;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.Profil;
import fr.pizzeria.model.Utilisateur;

@WebServlet("/admin/users/new")
public class SaveUtilisateurController extends HttpServlet {

	@Inject
	private UtilisateurService uService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setAttribute("profils", uService.getProfils());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/users/creerUtilisateur.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String mdp = req.getParameter("hashOutputText").toUpperCase();
		Profil profil = uService.getProfil(req.getParameter("profil"));
		Utilisateur newU = new Utilisateur(nom, prenom, email, mdp, profil);

		uService.enregistrerUtilisateur(newU);
		resp.sendRedirect("./list");
	}
}