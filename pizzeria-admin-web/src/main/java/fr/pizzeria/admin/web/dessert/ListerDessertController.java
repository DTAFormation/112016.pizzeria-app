package fr.pizzeria.admin.web.dessert;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.DessertService;
import fr.pizzeria.model.Dessert;

/**
 * Servlet implementation class ListerDessertController
 */
@WebServlet("/admin/desserts/list")
public class ListerDessertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DessertService dessertService;
	private static final String VUE_LISTER_BOISSON = "/WEB-INF/views/desserts/listDesserts.jsp";

	public ListerDessertController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Dessert> listerDesserts = dessertService.listerDesserts();
		request.setAttribute("listerDesserts", listerDesserts);
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_LISTER_BOISSON);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
