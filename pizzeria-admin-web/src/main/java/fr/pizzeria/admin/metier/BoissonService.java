package fr.pizzeria.admin.metier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Boisson;

@Stateless
public class BoissonService {

	@PersistenceContext
	private EntityManager em;

	public void createBoisson(Boisson b) {
		em.persist(b);
	}

}
