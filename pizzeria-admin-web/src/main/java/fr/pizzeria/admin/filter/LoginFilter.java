package fr.pizzeria.admin.filter;

import fr.pizzeria.admin.metier.CommandeService;
import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.Utilisateur;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = { "/admin/*" }, description = "Authentification")
public class LoginFilter implements Filter {

	@EJB
	private UtilisateurService utilisateurService;

	@Inject
	private CommandeService commandeService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		if(user!=null){

		    session.setAttribute("lastCommands", commandeService.getThreeLasts());
			session.setAttribute("user", user);
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/pizzeria-admin-web/login");
		}
	}

	@Override
	public void destroy() {}

}
