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

@WebServlet("/admin/clients/update")
public class UpdateClientController extends HttpServlet {

	@EJB
	private ClientService clientService;

	private static final String VUE_UPDATE_CLIENT = "/WEB-INF/views/clients/updateClients.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		Client c = clientService.retrieveClient(id);
		req.setAttribute("client", c);

		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_UPDATE_CLIENT);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("nom").toUpperCase();
		String prenom = req.getParameter("prenom").toLowerCase();
		String email = req.getParameter("email");
		String adresse = req.getParameter("adresse");

		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setAdresse(adresse);
		clientService.updateClient(id, c);

		resp.sendRedirect(req.getContextPath() + "/admin/clients/list");
	}

}
