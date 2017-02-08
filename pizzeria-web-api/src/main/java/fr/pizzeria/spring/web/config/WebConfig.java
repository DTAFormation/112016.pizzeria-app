package fr.pizzeria.spring.web.config;

import fr.pizzeria.spring.web.filter.AuthentificationFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean authentificationFilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("AuthUser");
        AuthentificationFilter authFilter = new AuthentificationFilter();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
