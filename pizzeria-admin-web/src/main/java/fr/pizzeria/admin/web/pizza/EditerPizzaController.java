package fr.pizzeria.admin.web.pizza;

import java.io.IOException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.metier.form.PizzaForm;
import fr.pizzeria.model.Pizza;

@WebServlet("/admin/pizzas/edit")
public class EditerPizzaController extends HttpServlet {

	private static final String VUE_AJOUTER_PIZZA 	= "/WEB-INF/views/pizzas/afficherPizza.jsp";
	private static final String LIST_CONTROLLER		= "/admin/pizzas/list?urlMessage=";
	
	@Inject private PizzaForm form;
	@Inject private PizzaService pizzaService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("pizza", pizzaService.get(req.getParameter("code")));
		req.setAttribute("categories", pizzaService.getListCategories());
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AJOUTER_PIZZA);
	    dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pizza pizza = form.modifierPizzaForm(req);
		
		req.setAttribute("pizza", pizza);
		
		if(form.getErreurs().isEmpty()) {
			resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER + URLEncoder.encode(form.getResultat(), "UTF-8"));
		} else {
			req.setAttribute("form", form);
			req.setAttribute("categories", pizzaService.getListCategories());
			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_PIZZA).forward(req, resp);
		}
	}
}
