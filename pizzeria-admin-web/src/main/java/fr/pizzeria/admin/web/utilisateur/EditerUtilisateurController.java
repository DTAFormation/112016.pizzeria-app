package fr.pizzeria.admin.web.utilisateur;

import java.io.IOException;
import java.util.logging.Logger;

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

@WebServlet("/admin/users/edit")
public class EditerUtilisateurController extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(ListerUtilisateurController.class.getName());
	private static final String VUE_EDITER_UTILISATEURS = "/WEB-INF/views/users/editerUtilisateur.jsp";

	@Inject
	private UtilisateurService uService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("oldUtilisateur", this.uService.getUtilisateurById(id));
		req.setAttribute("profils", uService.getProfils());
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_EDITER_UTILISATEURS);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur current = new Utilisateur();
		current.setNom(req.getParameter("nom"));
		current.setPrenom(req.getParameter("prenom"));
		current.setEmail(req.getParameter("email"));
		Profil profil = uService.getProfil(req.getParameter("profil"));
		current.setProfil(profil);
		String id = req.getParameter("id");// id passee par l'url
		uService.updateUtilisateur(id, current);
		resp.sendRedirect("/admin/users/list");
	}
}
