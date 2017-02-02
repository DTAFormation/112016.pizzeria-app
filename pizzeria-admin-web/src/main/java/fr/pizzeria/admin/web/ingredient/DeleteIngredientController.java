package fr.pizzeria.admin.web.ingredient;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;

@WebServlet("/admin/ingredients/delete")
public class DeleteIngredientController extends HttpServlet{

	private static final String LIST_CONTROLLER			= "/admin/ingredients/list";
	
	@EJB
	private IngredientService ingredientService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String id = req.getParameter("id");
		ingredientService.deleteIngredient(Integer.valueOf(id));
		
		resp.sendRedirect(req.getContextPath() + LIST_CONTROLLER);
	}
}
