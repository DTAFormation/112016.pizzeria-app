package fr.pizzeria.spring.web.resource;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.spring.web.repository.IPizzaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource Pizza.
 */
@RestController
@RequestMapping("/pizzas")
public class PizzaResource {

  @Autowired private IPizzaRepository pizzaDao;

  @RequestMapping(method = RequestMethod.GET)
  public List<Pizza> listAllPizzas() {
    return pizzaDao.findAll();
  }

}
