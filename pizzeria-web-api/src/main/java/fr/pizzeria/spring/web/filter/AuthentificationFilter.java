package fr.pizzeria.spring.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.resource.ClientResource;
import fr.pizzeria.spring.web.resource.auth.ClientAuth;

@Component
public class AuthentificationFilter implements Filter {

	@Autowired
	private ClientResource cResource;

	@Autowired
    private ClientAuth cAuth;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		Optional<String> userToken = Optional.ofNullable(request.getHeader("Token"));
		
		if(request.getMethod().equals("OPTIONS")) {
			chain.doFilter(req, resp);
		} else {
			Optional<Client> clientTrouve = findClient(userToken);
			
			if(clientTrouve.isPresent()) {
				Client client = clientTrouve.get();
				System.out.println("Client : " + client.getNom());
				System.out.println("Client Authentifié: " + client.getEmail());
				chain.doFilter(req, resp);
			} else {
				response.setHeader("Access-Control-Allow-Origin", "*");
		 		response.setStatus(401);
			}
		}
		
	}

	private Optional<Client> findClient(Optional<String> userToken) {
		Optional<Client> client = Optional.empty();
		
		if(userToken.isPresent()) {
			String decryptedToken = cAuth.decrypt(userToken.get());
			int index = decryptedToken.indexOf('&');
			String email = decryptedToken.substring(0, index);
			//Date date = new Date(Long.valueOf(decryptedToken.substring(index + 1)) * 1000);
			client = Optional.ofNullable(cResource.getClientByEmail(email));
		};
		
		
		
		return client;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
        //this.cAuth = new ClientAuth();
	}
}
