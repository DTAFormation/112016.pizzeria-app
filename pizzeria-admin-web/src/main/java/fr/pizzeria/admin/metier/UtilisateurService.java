package fr.pizzeria.admin.metier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Profil;
import fr.pizzeria.model.Utilisateur;

@Stateless
public class UtilisateurService {

	@PersistenceContext
	private EntityManager em;

	public void enregistrerUtilisateur(Utilisateur u) {
		em.persist(u);
	}

	public List<Utilisateur> findAll() {
		return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
	}

	public void updateUtilisateur(String id, Utilisateur u) {
		Utilisateur current = this.getUtilisateurById(Integer.valueOf(id));
		current.setNom(u.getNom());
		current.setPrenom(u.getPrenom());
		current.setEmail(u.getEmail());
		current.setProfil(u.getProfil());
		em.persist(current);
	}

	public void supprimerUtilisateur(String id) {
		Utilisateur u = this.getUtilisateurById(Integer.valueOf(id));
		em.remove(u);
	}

	public Utilisateur getUtilisateurById(Integer id) {
		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.id = :id",
				Utilisateur.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Utilisateur connexion(String email, String mdp) {
		List<Utilisateur> users = this.findAll();
		Optional<Utilisateur> user = users.stream()
				.filter(p -> p.getEmail().equals(email) && p.getMotDePasse().equals(mdp)).findFirst();
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public Map<String, String> getProfils() {
		Map<String, String> profils = new HashMap<>();
		Arrays.asList(Profil.values()).forEach(p -> {
			profils.put(p.name(), p.getPoste());
		});
		return profils;
	}

	public Profil getProfil(String profil) {
		if (profil.isEmpty()) {
			return null;
		}
		Profil profilSelected = Profil.valueOf(profil);
		if (profilSelected != null) {
			return profilSelected;
		} else {
			return null;
		}
	}

	public void updateClientPass(Integer id, Utilisateur u) {

		Utilisateur user = findAll().stream().filter(utilisateur -> utilisateur.getId() == id).findFirst().get();

		user.setMotDePasse(u.getMotDePasse());

		em.merge(user);
	}
}
