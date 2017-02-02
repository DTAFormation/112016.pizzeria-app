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

@WebServlet("/admin/users/list")
public class ListerUtilisateurController extends HttpServlet{

	private static final Logger LOG = Logger.getLogger(ListerUtilisateurController.class.getName());	
	private static final String VUE_LISTER_UTILISATEURS = "/WEB-INF/views/users/listerUtilisateurs.jsp";

	@Inject private UtilisateurService uService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String id = req.getParameter("code");
		String check = req.getParameter("action");
		if(check.equals("supprimer"))//pour mettre un peu de securite...
			uService.supprimerUtilisateur(id);
//		doGet(req, resp);
		resp.sendRedirect(req.getContextPath() + "/admin/users/list");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listeUtilisateurs", this.uService.findAll());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_LISTER_UTILISATEURS);
		dispatcher.forward(req, resp);
	}

}
