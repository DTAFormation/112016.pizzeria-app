package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Entree;

@Stateless
public class EntreeService {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Entree> listerEntrees() {
		TypedQuery<Entree> query = entityManager.createQuery("SELECT e FROM Entree e", Entree.class);
		return query.getResultList();
	}

	public void createEntre(Entree entree) {
		entityManager.persist(entree);
	}

	public void updateEntree(Integer id, Entree entre) {
		List<Entree> entree = listerEntrees();

		Entree monEntree = entree.stream().filter(e -> e.getId() == id).findFirst().get();

		monEntree.setNom(entre.getNom());
		monEntree.setPrix(entre.getPrix());
		monEntree.setUrlImage(entre.getUrlImage());

		entityManager.merge(monEntree);
	}

	public void deleteEntree(Integer id) {
		TypedQuery<Entree> query = entityManager.createQuery("SELECT e FROM Entree e WHERE e.id = :id", Entree.class);
		query.setParameter("id", id);
		Entree e = query.getSingleResult();

		entityManager.remove(e);
	}

	public Entree retrieveEntree(Integer id) {
		TypedQuery<Entree> query = entityManager.createQuery("SELECT e FROM Entree e WHERE e.id = :id", Entree.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

}
