package fr.pizzeria.admin.web.client;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.exception.ClientException;
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
		String mdp = req.getParameter("mdp1");
		String motDepasse = null;

		try {

			motDepasse = getMotDePasseToShaOne(mdp);

		} catch (ClientException e) {

			e.printStackTrace();

		}
		Logger.getLogger(UpdateClientPasswordController.class.getName()).info(motDepasse);
		Client c = new Client();
		c.setMotDePasse(motDepasse);
		clientService.updateClientPass(id, c);

		resp.sendRedirect(req.getContextPath() + "/admin/clients/list");
	}

	private String getMotDePasseToShaOne(String mdp) throws ClientException {
		byte[] shaOne;

		try {
			shaOne = MessageDigest.getInstance("SHA1").digest(mdp.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new ClientException(e);
		}

		return String.format("%032X", new BigInteger(1, shaOne));
	}
}
