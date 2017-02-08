package fr.pizzeria.admin.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Dessert;

public class DessertService {

	@PersistenceContext
	private EntityManager em;

	/*** CRUD ***/

	/*** Ajoute un client en base de donnee ***/
	public void createDessert(Dessert d) {
		em.merge(d);
	}

	/*** Modifie un client de la base de donnee ***/
	public void updateDessert(Integer id, Dessert d) {
		listerDesserts().forEach(Dessert -> {
			if (Dessert.getId() == id) {
				em.merge(d);
			}
		});

	}

	/*** Supprime un client de la base de donnee ***/
	public void deleteDessert(Integer id) {
		TypedQuery<Dessert> query = em.createQuery("SELECT d FROM Dessert d WHERE d.id = :id", Dessert.class);
		query.setParameter("id", id);
		Dessert d = query.getSingleResult();

		em.remove(d);
	}

	/*** Autres methodes ***/

	/***
	 * Recherche un client en base de donnees en base de donnee en fonction de
	 * son id
	 ***/
	public Dessert retrieveDessert(Integer id) {
		TypedQuery<Dessert> query = em.createQuery("SELECT d FROM Dessert d WHERE d.id = :id", Dessert.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	/***
	 * La methode listerDessert retourne une liste exhaustive des clients de la
	 * base de donnee
	 ***/
	public List<Dessert> listerDesserts() {
		TypedQuery<Dessert> query = em.createQuery("SELECT d FROM Dessert d", Dessert.class);
		return query.getResultList();
	}

}
