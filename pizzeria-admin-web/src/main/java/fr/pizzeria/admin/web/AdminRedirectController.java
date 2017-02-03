package fr.pizzeria.admin.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/admin", "/"})
public class AdminRedirectController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7032943734373490781L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.sendRedirect(response.encodeRedirectURL("./admin/home"));
	}

}
