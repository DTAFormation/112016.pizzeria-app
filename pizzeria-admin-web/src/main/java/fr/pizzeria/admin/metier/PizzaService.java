package fr.pizzeria.admin.metier;

import fr.pizzeria.model.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PizzaService {

  @PersistenceContext private EntityManager em;


  public List<Pizza> findAll() {
    return em.createQuery("select p from Pizza p", Pizza.class).getResultList();
  }

}
