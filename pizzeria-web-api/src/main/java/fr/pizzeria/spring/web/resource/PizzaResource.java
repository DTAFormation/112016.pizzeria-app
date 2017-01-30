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
			Pizza pizza = new Pizza();
			pizza.setCode_pizza("PMAR");
			pizza.setNom("margerita");
			pizza.setPrix(new BigDecimal(9.9));
			pizza.setNbre_note(1);
			pizza.setNote(4);
			pizza.setCategorie(CategoriePizza.SANS_VIANDE);
			pizza.setUrlImage("http://mister-check.e-monsite.com/medias/images/pizza2.jpg");

			Pizza pizza2 = new Pizza();
			pizza2.setCode_pizza("PPEP");
			pizza2.setNom("peperoni");
			pizza2.setNbre_note(1);
			pizza2.setNote(3);
			pizza2.setPrix(new BigDecimal(9.9));
			pizza2.setCategorie(CategoriePizza.VIANDE);
			pizza2.setUrlImage("http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg");

			pizzaDao.save(pizza);
			pizzaDao.save(pizza2);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Pizza> listAllPizzas() {
		return pizzaDao.findAll();
	}

}
