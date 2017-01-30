package fr.pizzeria.spring.web.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Boisson;
import fr.pizzeria.model.CategorieBoisson;
import fr.pizzeria.spring.web.repository.IBoissonRepository;

@RestController
@RequestMapping("/boissons")
public class BoissonResource {

	@Autowired
	private IBoissonRepository boissonDao;

	@PostConstruct
	public void init() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String mode = bundle.getString("post.construct.mode");

		if ("dev".equals(mode)) {
			Boisson boisson = new Boisson("coca", new BigDecimal(2.5),
					"http://media.topito.com/wp-content/uploads/2014/12/coca-250x250.jpg", CategorieBoisson.GAZ);
			Boisson boisson2 = new Boisson("oasis tropical", new BigDecimal(2.0),
					"http://medine-distribution.fr/219-home_default/oasis-tropical-50cl-x-24.jpg",
					CategorieBoisson.SANS_GAZ);
			boissonDao.save(boisson);
			boissonDao.save(boisson2);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Boisson> findAll() {
		return boissonDao.findAll();
	}
}
