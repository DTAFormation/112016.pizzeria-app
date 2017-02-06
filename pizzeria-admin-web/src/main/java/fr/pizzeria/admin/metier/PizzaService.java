package fr.pizzeria.admin.metier;

import fr.pizzeria.admin.web.activity.ActivitySessionManager;
import fr.pizzeria.admin.web.activity.ActivityWS;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class PizzaService {

    @Inject
    ActivitySessionManager ws;

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

        ws.trySend(pizza);
        em.persist(pizza);
    }

    public void update(Pizza pizza, String oldCode) {

        Pizza oldPizza = get(oldCode);
        oldPizza.setCode(pizza.getCode());
        oldPizza.setNom(pizza.getNom());
        oldPizza.setPrix(pizza.getPrix());
        oldPizza.setCategorie(pizza.getCategorie());
        oldPizza.setUrlImage(pizza.getUrlImage());
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
