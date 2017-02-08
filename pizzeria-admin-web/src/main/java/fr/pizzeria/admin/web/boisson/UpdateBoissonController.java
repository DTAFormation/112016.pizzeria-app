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

/**
 * Servlet implementation class UpdateBoissonController
 */
@WebServlet("/admin/boissons/edit")
public class UpdateBoissonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BoissonService boissonService;
	private static final String VUE_MODIFIER_BOISSON = "/WEB-INF/views/boissons/editBoissons.jsp";

	public UpdateBoissonController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Boisson boisson = boissonService.getBoisson(id);
		request.setAttribute("boisson", boisson);
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_MODIFIER_BOISSON);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String urlImage = request.getParameter("url_image");
		String categorie = request.getParameter("categorie");

		Boisson boisson = new Boisson(nom, new BigDecimal(prix), urlImage, CategorieBoisson.valueOf(categorie));

		boissonService.updateBoisson(id, boisson);

		response.sendRedirect(request.getContextPath() + "/admin/boissons/list");
		doGet(request, response);
	}

}
