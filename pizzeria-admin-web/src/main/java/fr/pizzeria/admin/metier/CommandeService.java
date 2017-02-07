package fr.pizzeria.admin.metier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Statut;

@Stateless
public class CommandeService {

	@PersistenceContext
	private EntityManager em;

	public List<Commande> findAll() {
		return em.createQuery("select p from Commande p", Commande.class).getResultList();
	}

	public Commande get(Integer id) {

		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE c.id =:id", Commande.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void save(Commande commande) {
		em.persist(commande);
	}

	public void update(Commande commande, Integer id) {
		em.merge(commande);

	}

	public void changeStatut(Integer id, Statut statut) {
		Commande commandeToUpdate = get(id);
		commandeToUpdate.setStatut(statut);
	}

	public void delete(Integer id) {
		Commande commande = get(id);
		em.remove(commande);
	}

	public Map<String, String> getListStatuts() {
		Map<String, String> statuts = new HashMap<>();
		Arrays.asList(Statut.values()).forEach(c -> {
			statuts.put(c.name(), c.getLabel());
		});
		return statuts;
	}

	public Commande getCommande(Integer id) {
		return em.find(Commande.class, id);
	}
}
