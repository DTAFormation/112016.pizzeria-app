package fr.pizzeria.admin.web.entree;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.EntreeService;
import fr.pizzeria.model.Entree;

@WebServlet("/admin/entrees/create")
public class CreateEntreeController extends HttpServlet {

	@EJB
	private EntreeService entreeService;

	private static final String VUE_CREER_ENTREE = "/WEB-INF/views/entrees/createEntree.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_CREER_ENTREE);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String image = req.getParameter("image");

		BigDecimal price = new BigDecimal(prix);

		Entree e = new Entree();

		e.setNom(nom);
		e.setPrix(price);
		e.setUrlImage(image);

		entreeService.createEntre(e);

		resp.sendRedirect(req.getContextPath() + "/admin/entrees/list");
	}
}
