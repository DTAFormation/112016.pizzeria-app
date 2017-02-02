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

@WebServlet("/admin/ingredients/list")
public class ListIngredientController extends HttpServlet{
	
	@EJB
	private IngredientService ingredientService;
	
	private static final String VUE_EDITER_INGREDIENT = "/WEB-INF/views/ingredients/listerIngredients.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setAttribute("listeIngredients", ingredientService.listerIngredients());
		RequestDispatcher dispatcher = req.getRequestDispatcher(VUE_EDITER_INGREDIENT);
		dispatcher.forward(req, resp);
	}
}
