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

@WebServlet("/admin/desserts/edit")
public class UpdateDessertController extends HttpServlet {

	@EJB
	private DessertService dessertService;
	private static final String VUE_MODIFIER_BOISSON = "/WEB-INF/views/desserts/editDesserts.jsp";

	public UpdateDessertController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Dessert dessert = dessertService.getDessert(id);
		request.setAttribute("dessert", dessert);
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_MODIFIER_BOISSON);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String urlImage = request.getParameter("url_image");

		Dessert dessert = new Dessert(nom, new BigDecimal(prix), urlImage);

		dessertService.updateDessert(id, dessert);

		response.sendRedirect(request.getContextPath() + "/admin/desserts/list");
		doGet(request, response);
	}

}
