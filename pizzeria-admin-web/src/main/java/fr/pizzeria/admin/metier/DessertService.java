package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Dessert;

@Stateless
public class DessertService {

	@PersistenceContext
	private EntityManager em;

	/*** CRUD ***/

	/*** Ajoute un dessert en base de donnee ***/
	public void createDessert(Dessert d) {
		em.persist(d);
	}

	/*** Modifie un dessert de la base de donnee ***/
	public void updateDessert(Integer id, Dessert d) {

		Dessert dessert = em.find(Dessert.class, id);
		d.setId(id);
		if (dessert != null) {
			em.merge(d);
		}

	}

	/*** Supprime un client de la base de donnee ***/
	public void deleteDessert(Integer id) {
		Dessert dessert = em.find(Dessert.class, id);
		if (dessert != null)
			em.remove(dessert);
	}

	/*** Autres methodes ***/

	/***
	 * Recherche un client en base de donnees en base de donnee en fonction de
	 * son id
	 ***/
	public Dessert getDessert(Integer id) {
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
