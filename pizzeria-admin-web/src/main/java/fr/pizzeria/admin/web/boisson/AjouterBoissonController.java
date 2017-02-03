package fr.pizzeria.admin.web.boisson;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.BoissonService;
import fr.pizzeria.model.Boisson;
import fr.pizzeria.model.CategorieBoisson;

@WebServlet("/admin/boissons/add")
public class AjouterBoissonController extends HttpServlet {

	@EJB
	BoissonService boissonService;
	private static final String VUE_AJOUTER_BOISSON = "/WEB-INF/views/boissons/ajouterBoissons.jsp";
	private static final long serialVersionUID = 1L;

	public AjouterBoissonController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_AJOUTER_BOISSON);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String urlImage = request.getParameter("url_image");
		String categorie = request.getParameter("categorie");

		Boisson boisson = new Boisson(nom, new BigDecimal(prix), urlImage, CategorieBoisson.valueOf(categorie));

		boissonService.createBoisson(boisson);

		response.sendRedirect(request.getContextPath() + "/admin/boissons/list");

	}

}
