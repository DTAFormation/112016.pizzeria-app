package fr.pizzeria.admin.web.ingredient;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.model.Ingredient;

@WebServlet("/admin/ingredients/update")
public class UpdateIngredientController extends HttpServlet{
	
	@EJB
	private IngredientService ingredientService;
	
	private static final String VUE_UPDATE_INGREDIENT 	= "/WEB-INF/views/ingredients/updateIngredients.jsp";
	private static final String LIST_CONTROLLER			= "/admin/ingredients/list";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		Ingredient i = ingredientService.retrieveIngredient(id);
		req.setAttribute("ingredient", i);

		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_UPDATE_INGREDIENT);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{		
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("nom");
		
		Ingredient i = new Ingredient(id, nom);
		
		ingredientService.updateIngredient(id, i);
		
		resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER);
	}
}
