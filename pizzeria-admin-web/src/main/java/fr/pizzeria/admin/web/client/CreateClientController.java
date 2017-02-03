package fr.pizzeria.admin.web.client;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

@WebServlet("/admin/clients/create")
public class CreateClientController extends HttpServlet {

	@EJB
	private ClientService clientService;

	private static final String VUE_CREER_CLIENT = "/WEB-INF/views/clients/createClients.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_CREER_CLIENT);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nom = req.getParameter("nom").toUpperCase();
		String prenom = req.getParameter("prenom").toLowerCase();
		String email = req.getParameter("email");
		String adresse = req.getParameter("adresse");
		String mdp = req.getParameter("mdp");
		String motDepasse = null;

		try {

			motDepasse = getMotDePasseToShaOne(mdp);

		} catch (ClientException e) {

			e.printStackTrace();

		}

		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setMotDePasse(motDepasse);
		c.setAdresse(adresse);
		clientService.createClient(c);

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
