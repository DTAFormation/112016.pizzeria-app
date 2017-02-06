package fr.pizzeria.admin.web.dessert;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.DessertService;
import fr.pizzeria.model.Dessert;

@WebServlet("/admin/desserts/add")
public class AjouterDessertController extends HttpServlet {

	@EJB
	DessertService dessertService;
	private static final String VUE_AJOUTER_BOISSON = "/WEB-INF/views/desserts/ajouterDesserts.jsp";
	private static final long serialVersionUID = 1L;

	public AjouterDessertController() {
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

		Dessert dessert = new Dessert(nom, new BigDecimal(prix), urlImage);

		dessertService.createDessert(dessert);

		response.sendRedirect(request.getContextPath() + "/admin/desserts/list");

	}

}
