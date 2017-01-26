package fr.pizzeria.admin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CompteurSessionListener implements HttpSessionListener {
	
	private Integer compteurSession = 0;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		compteurSession++;
		event.getSession().getServletContext().setAttribute("compteurSession", compteurSession);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		compteurSession--;
		event.getSession().getServletContext().setAttribute("compteurSession", compteurSession);
	}
}