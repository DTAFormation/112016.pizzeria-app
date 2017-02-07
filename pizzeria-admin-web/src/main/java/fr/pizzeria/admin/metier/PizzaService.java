package fr.pizzeria.admin.metier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaService {

	@PersistenceContext
	private EntityManager em;

	public List<Pizza> findAll() {
		return em.createQuery("select p from Pizza p", Pizza.class).getResultList();
	}

	public Pizza get(String code) {

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code =:code", Pizza.class);
		query.setParameter("code", code);
		return query.getSingleResult();
	}

	public Pizza get(int id) {
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.id =:id", Pizza.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void save(Pizza pizza) {
		em.persist(pizza);
	}

	public void update(Pizza pizza, String oldCode) {

		Pizza oldPizza = get(oldCode);
		oldPizza.setCode(pizza.getCode());
		oldPizza.setNom(pizza.getNom());
		oldPizza.setPrix(pizza.getPrix());
		oldPizza.setCategorie(pizza.getCategorie());
		oldPizza.setUrlImage(pizza.getUrlImage());
		oldPizza.setIngredients(pizza.getIngredients());
	}

	public void delete(String code) {
		Pizza pizza = get(code);
		em.remove(pizza);
	}

	public boolean checkCode(String code) {
		return findAll().stream().map(Pizza::getCode).filter(f -> f.equals(code)).findAny().isPresent();
	}

	public Map<String, String> getListCategories() {
		Map<String, String> categories = new HashMap<>();
		Arrays.asList(CategoriePizza.values()).forEach(p -> {
			categories.put(p.name(), p.getLibelle());
		});
		return categories;
	}
}
