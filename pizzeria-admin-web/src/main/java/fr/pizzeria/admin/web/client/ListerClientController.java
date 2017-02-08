package fr.pizzeria.admin.web.client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.ClientService;

@WebServlet("/admin/clients/list")
public class ListerClientController extends HttpServlet {

	@EJB
	private ClientService clientService;

	private static final String VUE_LISTER_CLIENT = "/WEB-INF/views/clients/listClients.jsp";

	/*** Enrichit l'URL avec la liste exhaustive des clients ***/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setAttribute("listeClients", clientService.listerClients());
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_LISTER_CLIENT);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		clientService.deleteClient(Integer.valueOf(id));
		resp.sendRedirect(req.getContextPath() + "/admin/clients/list");
	}
}
