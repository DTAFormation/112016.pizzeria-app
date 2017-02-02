package fr.pizzeria.admin.filter;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.Utilisateur;

@WebFilter(urlPatterns = { "/admin/*" }, description = "Authentification")
public class LoginFilter implements Filter {

	@EJB
	private UtilisateurService utilisateurService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if(user!=null){
			session.setAttribute("user", user);
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/pizzeria-admin-web/login");
		}
	}

	@Override
	public void destroy() {}

}
