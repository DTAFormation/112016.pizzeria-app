package fr.pizzeria.admin.web.entree;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.EntreeService;

/**
 * Servlet implementation class ListerEntreeController
 */
@WebServlet("/admin/entrees/list")
public class ListerEntreeController extends HttpServlet {

	@EJB
	private EntreeService entreeService;

	private static final String VUE_LISTER_ENTREE = "/WEB-INF/views/entrees/listEntrees.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listeEntrees", entreeService.listerEntrees());
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_LISTER_ENTREE);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		entreeService.deleteEntree(Integer.valueOf(id));
		response.sendRedirect(request.getContextPath() + "/admin/entrees/list");

	}

}
