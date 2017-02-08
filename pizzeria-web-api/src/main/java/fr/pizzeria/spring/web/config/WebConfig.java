package fr.pizzeria.spring.web.config;

import fr.pizzeria.spring.web.filter.AuthentificationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
	
	@Autowired AuthentificationFilter authFilter;

    @Bean
    public FilterRegistrationBean authentificationFilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("AuthUser");
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/client/*");
        registration.addUrlPatterns("/commandes/*");
        return registration;
    }
}
