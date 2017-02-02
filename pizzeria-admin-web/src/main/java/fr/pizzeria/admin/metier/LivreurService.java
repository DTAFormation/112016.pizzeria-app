package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;

@Stateless
public class LivreurService {

	
	@PersistenceContext private EntityManager em;

	/**
	 * return list of livreur
	 * */
	public List<Livreur> findAll(){
		return em.createQuery("select l from Livreur l", Livreur.class).getResultList();
	}
	
	public Livreur get(Integer id) {
		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l WHERE l.id =:id", Livreur.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	
	public void save(Livreur livreur){
//		em.getTransaction().begin();
		em.persist(livreur); 
//		em.getTransaction().commit(); 
	}
	
	public void delete(int idLivreur){
		em.remove(findAll().stream().filter(p -> p.getId().equals(idLivreur)).findFirst().get());
	}
	
	
	public void update(Livreur livreur){
		Livreur newLivreur = em.find(Livreur.class, livreur.getId());
		newLivreur.setNom(livreur.getNom());
		newLivreur.setPrenom(livreur.getPrenom());
		newLivreur.setEmail(livreur.getEmail());
	}
}
