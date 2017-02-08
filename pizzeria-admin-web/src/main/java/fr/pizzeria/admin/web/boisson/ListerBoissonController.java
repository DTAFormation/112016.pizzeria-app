package fr.pizzeria.admin.web.boisson;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.BoissonService;
import fr.pizzeria.model.Boisson;

@WebServlet("/admin/boissons/list")
public class ListerBoissonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	BoissonService boissonService;
	private static final String VUE_LISTER_BOISSON = "/WEB-INF/views/boissons/listBoissons.jsp";

	public ListerBoissonController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Boisson> listerBoissons = boissonService.listerBoissons();
		request.setAttribute("listerBoissons", listerBoissons);
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_LISTER_BOISSON);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
