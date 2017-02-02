package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Ingredient;

@Stateless
public class IngredientService {
	
	//http://localhost:8080/pizzeria-admin-web/ingredients/
	
	@PersistenceContext private EntityManager em;
	
	 /***CRUD***/
	
	/***Ajoute un Ingredient en base de donnee***/
	public void createIngredient(Ingredient i){
		em.merge(i);		
	}
	
	/***Modifie un Ingredient de la base de donnee***/
	public void updateIngredient(Integer id, Ingredient i){
		Ingredient oldIngredient = retrieveIngredient(id);
		oldIngredient.setNom(i.getNom());
	}
	
	/***Supprime un Ingredient de la base de donnee***/
	public void deleteIngredient(Integer id){
		em.remove(retrieveIngredient(id));
	}

	/***Autres methodes***/
	
	/***Recherche un Ingredient en base de donnees en base de donnee en fonction de son id***/
	public Ingredient retrieveIngredient(Integer id){
		TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.id = :id", Ingredient.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	
	/***La methode listerIngredient retourne une liste exhaustive des Ingredients de la base de donnee***/
	public List<Ingredient> listerIngredients(){
		TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
		return query.getResultList();
	}
	

}
