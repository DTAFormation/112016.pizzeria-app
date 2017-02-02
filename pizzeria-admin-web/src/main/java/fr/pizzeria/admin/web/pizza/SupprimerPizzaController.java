package fr.pizzeria.admin.web.pizza;

import java.io.IOException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.form.PizzaForm;

@WebServlet("/admin/pizzas/delete")
public class SupprimerPizzaController extends HttpServlet {
	
	private static final String LIST_CONTROLLER	= "/admin/pizzas/list?urlMessage=";

	@Inject private PizzaForm form;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		form.deletePizzaForm(req);
		resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER +  URLEncoder.encode(form.getResultat(), "UTF-8"));
	}
}
