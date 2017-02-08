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
import fr.pizzeria.model.Client;

@WebServlet("/admin/clients/update/password")
public class UpdateClientPasswordController extends HttpServlet {

	@EJB
	private ClientService clientService;

	private static final String VUE_UPDATE_CLIENT_PASSWORD = "/WEB-INF/views/clients/updateClientsPassword.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Client c = clientService.retrieveClient(id);
		req.setAttribute("client", c);
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_UPDATE_CLIENT_PASSWORD);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String mdp = req.getParameter("hashOutputText").toUpperCase();

		Client c = new Client();
		c.setMotDePasse(mdp);
		clientService.updateClientPass(id, c);

		resp.sendRedirect(req.getContextPath() + "/admin/clients/list");
	}

}
