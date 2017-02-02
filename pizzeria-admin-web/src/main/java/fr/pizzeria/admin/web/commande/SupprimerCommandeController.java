package fr.pizzeria.admin.web.commande;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/commandes/delete")
public class SupprimerCommandeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7853122212848814053L;
	private static final String LIST_CONTROLLER	= "/admin/commandes/list";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("list");
	}
}
