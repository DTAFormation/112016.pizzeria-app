package fr.pizzeria.spring.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.spring.web.resource.ClientResource;
import fr.pizzeria.spring.web.resource.auth.ClientAuth;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

	
	@Autowired
	private ClientResource cResource;
	
	@Autowired
	private ClientAuth cAuth;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String userToken = request.getHeader("user-token");
		String email = cAuth.decrypt(userToken);
		System.out.println(userToken + " => " + email);
		cResource.getClientByEmail(email);
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
