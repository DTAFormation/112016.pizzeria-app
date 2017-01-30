package fr.pizzeria.spring.web.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.spring.web.repository.IPizzaRepository;

/**
 * Resource Pizza.
 */
@RestController
@RequestMapping("/pizzas")
public class PizzaResource {

	@Autowired
	private IPizzaRepository pizzaDao;

	@PostConstruct
	public void init() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String mode = bundle.getString("post.construct.mode");
		if ("dev".equals(mode)) {

			Pizza pizza = new Pizza("PMAR", "margerita", "http://mister-check.e-monsite.com/medias/images/pizza2.jpg",
					new BigDecimal(9.9), 4, 1, CategoriePizza.SANS_VIANDE);

			Pizza pizza2 = new Pizza("PPEP", "peperoni",
					"http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg", new BigDecimal(9.9), 3, 1,
					CategoriePizza.SANS_VIANDE);

			pizzaDao.save(pizza);
			pizzaDao.save(pizza2);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Pizza> listAllPizzas() {
		return pizzaDao.findAll();
	}

}
