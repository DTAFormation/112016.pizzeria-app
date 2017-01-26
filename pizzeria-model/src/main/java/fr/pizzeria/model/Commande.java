package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroCommande;
	@Enumerated(EnumType.STRING)
	private StatutCommande statut;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateCommande;
	@ManyToOne
	private Livreur livreur;
	@ManyToOne
	private Client client;
	
	@OneToMany
	@JoinTable(name = "commande_pizza", 
	joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizzas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}

	public Calendar getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Pizza> getPizzas() {
		return new ArrayList<>(pizzas);
	}
	
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numeroCommande=" + numeroCommande + "]";
	}
	
	
}
