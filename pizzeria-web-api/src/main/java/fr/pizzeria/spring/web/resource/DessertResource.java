package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Dessert;
import fr.pizzeria.spring.web.repository.IDessertRepository;

@RestController
@RequestMapping("/desserts")
public class DessertResource {

	@Autowired
	private IDessertRepository dessertDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Dessert> findAll() {
		return dessertDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutDessert(@RequestBody Dessert dessert) {
		dessertDao.save(dessert);
	}
}
